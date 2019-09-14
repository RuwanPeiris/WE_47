package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.service.ComplexityInheritance;
import complexity_measuring_tool.service.FileRead;
import complexity_measuring_tool.util.CommonParams;

/*
 * @Author  Peiris.M.R.P
 * IT16173064
 * 
 */

class ComplexityInheritanceTest {
	String fileName = "BrandController.java";
	File requestFile = new File(CommonParams.LOCAL_TEST_FILE_FOLDER_PATH + fileName);
	ArrayList<String> fileLines = FileRead.getFileStringLines(requestFile);
	long curMilliseconds = System.currentTimeMillis();
	Date date = new Date(curMilliseconds);
//	CheckFile checkFile = new CheckFile(fileName, fileLines, date);

	@Test
	void test() {
		int ci = 0;
//		ci = ComplexityInheritance.calculateCi(checkFile);
		assertEquals(5, ci);
		assertNotEquals(6, ci);
		
	}
	
//	@Test
//	void testComplexityInheritanceSaveSucessfillytoDB() {
//		boolean inserted=false;
//		try {
//			Class.forName ("org.h2.Driver");
//			Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
//			
//			String sqlDropTB1 = "DROP TABLE IF EXISTS FILE";
//			
//			String sqlTable1 = "CREATE TABLE file (\r\n" + 
//					"fileId int not null AUTO_INCREMENT PRIMARY KEY ,\r\n" + 
//					"fileName varchar(100) ,\r\n" + 
//					"date varchar(150) ,\r\n" + 
//					"cs int,\r\n" + 
//					"cns int,\r\n" + 
//					"cts int,\r\n" + 
//					"ci int,\r\n" + 
//					"cr int,\r\n" + 
//					"tw int \r\n" + 
//					")";
//			
//			Statement st = conn.createStatement();
//			
//			st.executeUpdate(sqlDropTB1);
//			st.executeUpdate(sqlTable1);
//			
//			DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//			String dateTime = df.format(checkFile.getDate());
//
//			String sql = "Insert into file values(" + 0 + ",'" + checkFile.getFileName() + "','" + dateTime + "','"
//					+ checkFile.getCs() + "','" + checkFile.getCns() + "','" + checkFile.getCts() + "','"
//					+ checkFile.getCi() + "','" + checkFile.getCr() + "','" + checkFile.getTw() + "')";
//
//			int resp = st.executeUpdate(sql);
//			
//			if(resp > 0) {
//				inserted= true;
//			}else {
//				inserted = false;
//			}
//			conn.close(); 
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} 
//		
//		//Assertion starts here
//		assertEquals(true, inserted);
//		assertNotEquals(false, inserted);
//		
//	}

}
