package complexity_measuring_tool.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import complexity_measuring_tool.dbaccess.FileAccess;
import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.util.CommonParams;
import complexity_measuring_tool.util.MyStack;

/*
 * @Author Peiris.M.R.P
 * IT16173064
 */
public class ComplexityForLine {

	// Create your variables here
	static int cs = 0;//OK
	static int ci = 0;//OK
	static int ctc = 0;//OK
	static int cns = 0;//OK
	static int tw = 0;
	static int cr = 0;
	static int cps = 0;
	
	private static Logger logger = Logger.getLogger(ComplexityInheritance.class.getName());

	public static boolean calculate(CheckFile checkFile) {
		boolean res=false;
		// File handler open to write logs
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(CommonParams.LOG_FILE_PATH, true);
			logger.addHandler(fileHandler);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandler.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			logger.info("Error occured while handling the file in " + CommonParams.LOG_FILE_PATH
					+ " exception ocured due to " + e.getCause());
			e.printStackTrace();
		}

		ArrayList<ViewRecord> viewRecords = new ArrayList<ViewRecord>();
		final MyStack  myStack = new MyStack();
		if (checkFile != null) {
			// Check line by line in the file
			for (ViewRecord viewRecord : checkFile.getFileLines()) {
				if (viewRecord.getValue() != null) {
					ci = ComplexityInheritance.calculateCi(viewRecord.getValue());
					cns = ComplexityNesting.calculateNestingComplexity(viewRecord.getValue(),myStack);
					ctc = ComplexityType.calculateCts(viewRecord.getValue());
					cs = ComplexityCs.calculateCs(viewRecord.getValue());
					//tw = calculate this one here
					//cr = ComplexityRecur.calculateCr(viewRecord.getValue());
					//cps = ComplexityCps.calculatecps(viewRecord.getValue());

					viewRecord.setCi(ci);
					viewRecord.setCns(cns);
					viewRecord.setCts(ctc);
					viewRecord.setCs(cs);
					viewRecord.setTw(tw);
					viewRecord.setCr(cr);
					viewRecord.setCr(cps);
					viewRecords.add(viewRecord);
				}
			}
			checkFile.setFileLines(viewRecords);

			// Save file to database
			try {
				res = FileAccess.saveFileData(checkFile);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			resetStaticVariables();
			logger.info("Total inheritance complexity of " + checkFile.getFileName() + " is :" + ci);
			logger.info("-----------------------------------------------------------------------------");
			logger.info("Total nesting complexity of " + checkFile.getFileName() + " is :" + cns);
			logger.info("-----------------------------------------------------------------------------");
			fileHandler.close();
		}
		return res;
	}

	private static void resetStaticVariables() {
		ci = 0;
		ctc = 0;
		cns = 0;
		tw = 0;
		cs = 0;
		cr = 0;
		cps = 0;
		new MyStack();
	}
}
