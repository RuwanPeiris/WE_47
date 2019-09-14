package complexity_measuring_tool.util;

/*
 * @author IT16173064
 * Peiris M.R.P
 */

public class CommonParams {
	
	public static final int ARRAY_FIRST_ELEMENT = 0;
	public static final int ARRAY_SECOND_ELEMENT = 1;
	public static final String LOCAL_UPLOAD_FILE_FOLDER_PATH = "C:/Users/Asus/Desktop/SPM/WE_47/complexity_measuring_tool/WebContent/uploaded-files/";
	public static final String REGEX_FOR_LOOP = "(\\s+|)for(\\s+|)\\((\\s|)\\w+\\s+\\w+(\\s+|)=(\\s+|)\\d+;(\\s+|)\\w+(\\s+|)(\\<|\\>|\\<=|\\>=)(\\s+|)\\d+;(\\s+|)\\w+(\\++|\\--)\\)(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_FOR_EACH = "(\\s+|)for(\\s+|)\\((\\s|)\\w+\\s+\\w+(\\s+|):(\\s+|)\\w+(\\s+|)\\)(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_WHILE_LOOP = "(\\s+|)while(\\s+|)\\((\\s|)+((\\w+(\\s|)+(\\<|\\>|\\=|\\<=|\\>=)(\\s|)+(\\w+|\\d+|\\w+\\.\\w+\\((\\w+|\\d+)\\)))|(\\w+)|(\\w+\\.\\w+\\((\\w+|)\\)))(\\s+|)\\)(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_IF = "(\\s+|)if(\\s+|)\\((\\s|)+((\\w+(\\s|)+(\\<|\\>|\\=|\\<=|\\>=|==|!=)(\\s|)+(\\w+|\\d+|\\w+\\.\\w+\\((\\w+|\\d+)\\)))|(\\w+))(\\s+|)\\)(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_SWITCH = "(\\s+|)switch(\\s+|)\\((\\s|)+((\"\\w+\")|(\'\\w\')|\\d|\\w)(\\s|)+\\)(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_ELSE = "(\\s+|)}(\\s+|)else(\\s+|)\\{(\\s|\\n|)";
	public static final String REGEX_METHOD_SIGNATURE=  "^([_0-9a-zA-Z()]+)\\{";
	public static final String LINE_ENDS_WITH_CURLY=  "(\\s+|)\\{(\\s+|)";
	public static final String LINE_STARTS_WITH_CURLY=  "(\\s+|)\\}(\\s+|)";
	public static final String LOG_FILE_PATH = "C:/COMPLEXITY/LOG/complexity.log";
	public static final String LOCAL_TEST_FILE_FOLDER_PATH = "C:/Users/Asus/Desktop/SPM/WE_47/complexity_measuring_tool/WebContent/testfile/";
}
