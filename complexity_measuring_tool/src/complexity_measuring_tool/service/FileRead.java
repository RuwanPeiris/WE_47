package complexity_measuring_tool.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author IT16173064
 * Peiris.M.R.P
 *
 */
public class FileRead {
	private static Logger logger;
	/*
	 * getFileStringLines
	 * @params(File file)
	 * method to retrieve data from given file
	 */
	public static ArrayList<String> getFileStringLines(File file) {
		
		ArrayList<String> fileLines =new ArrayList<>();
		try {
			BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
			String line=null;
			while(true) {
				line=bufferedReader.readLine();
				if(null == line ) {
					break;
				}else {
					fileLines.add(line);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			logger.log(Level.INFO, "File not found at "+ file.getPath() + " ERROR "+e.getMessage());
		} catch (IOException e) {
			logger.log(Level.INFO, "I/O exception while reading the file "+ file.getPath() + " ERROR "+ e.getMessage());
		}
		
		return fileLines;
	}
	

}
