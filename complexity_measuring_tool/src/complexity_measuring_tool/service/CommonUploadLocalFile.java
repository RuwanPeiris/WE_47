package complexity_measuring_tool.service;

import java.io.File;

import complexity_measuring_tool.util.CommonParams;
/*
 * 
 * @author Peiris.M.R.P
 * IT16173064
 */
public class CommonUploadLocalFile {
	
	public static void removeFilesInLocalUploadFolder() {
		//Removing temporary saved file in uploaded-files in WEB-INF after manipulations are done, to prevent unusual content save in local db
		File directory = new  File(CommonParams.LOCAL_UPLOAD_FILE_FOLDER_PATH);
		String[] files = directory.list();
		for (String file : files) {
			File currentFile=new File(directory.getPath(),file);
			currentFile.delete();
		}
	}

}
