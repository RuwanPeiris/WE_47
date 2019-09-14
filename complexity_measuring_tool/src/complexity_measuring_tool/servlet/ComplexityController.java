package complexity_measuring_tool.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import complexity_measuring_tool.dbaccess.RecordAcess;
import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.service.CommonUploadLocalFile;
import complexity_measuring_tool.service.ComplexityForLine;
import complexity_measuring_tool.service.FileRead;
import complexity_measuring_tool.util.CommonParams;

/**
 * 
 * @author Nimesh,Tharindu,Dananji,Ruwan
 * 
 *         ComplexityController
 */
@WebServlet("/ComplexityController")
@MultipartConfig
public class ComplexityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private File logFolder = new File("C:/COMPLEXITY/LOG");
	private File logFile = new File(CommonParams.LOG_FILE_PATH);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ComplexityController() {
		super();
		// Creating Log folder if does not exist in Windows system
		if (!logFolder.exists()) {
			logFolder.mkdirs();
		}
		// Creating if log file does not exist
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get file part
		Part filePart = request.getPart("file");

		String fileName = "";
		String fileNameWithAbsolutePath = "";
		// Get file parts and retrieve the received file name
		for (Part part : request.getParts()) {
			fileNameWithAbsolutePath = extractFileName(part);
		}

		String[] splittedFilePath = fileNameWithAbsolutePath.split("\\\\");
		fileName = splittedFilePath[splittedFilePath.length - 1];

		InputStream inputStream = filePart.getInputStream();

		// Removing files in local uploaded-file folder
		CommonUploadLocalFile.removeFilesInLocalUploadFolder();

		// Create file object to save the file in Local folder
		File requestFile = new File(CommonParams.LOCAL_UPLOAD_FILE_FOLDER_PATH + fileName);
		Files.copy(inputStream, requestFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		// Read file and get file line by line as String Array object
		ArrayList<String> fileLines = FileRead.getFileStringLines(requestFile);
		ArrayList<ViewRecord> viewRecords = new ArrayList<ViewRecord>();
		for (String fileLine : fileLines) {
			ViewRecord record = new ViewRecord();
			record.setValue(fileLine);
			viewRecords.add(record);
		}
		long curMilliseconds = System.currentTimeMillis();
		Date date = new Date(curMilliseconds);
		CheckFile checkFile = new CheckFile(fileName, viewRecords, date);
		
		boolean res= false;
		if (null != checkFile) {
			// Calling calculations here
			res = ComplexityForLine.calculate(checkFile);
		}

		// Retrieving latest history file records from db
		ArrayList<ViewRecord> recordList = new ArrayList<ViewRecord>();
		if(res == true) {
			recordList = RecordAcess.retriveRecords(fileName);
		}

		if (recordList != null && recordList.size() > 0) {
			// Set your attributes here
			// Set attributes to retrieve from result page
			request.setAttribute("recordList", recordList);
			request.setAttribute("fileName", fileName);
			request.setAttribute("old_datTime", date);
			request.setAttribute("oldFileNotFound", "false");
		} else {
			request.setAttribute("oldFileNotFound", "true");
		}

		// Removing files in local uploaded-file folder after works done in Complexity
		// Controller
		CommonUploadLocalFile.removeFilesInLocalUploadFolder();
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	// Private method to extract file name
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
