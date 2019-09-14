package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.annotation.Testable;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.service.ComplexityNesting;
import complexity_measuring_tool.service.FileRead;
import complexity_measuring_tool.util.CommonParams;

class ComplexityNestingTest {
	
	String fileName = "BrandController.java";
	File requestFile = new File(CommonParams.LOCAL_TEST_FILE_FOLDER_PATH + fileName);
	ArrayList<String> fileLines = FileRead.getFileStringLines(requestFile);
	long curMilliseconds = System.currentTimeMillis();
	Date date = new Date(curMilliseconds);
//	CheckFile checkFile = new CheckFile(fileName, fileLines, date);
	
	@Test
	void test() {
		int cn = 0;
//		cn = ComplexityNesting.calculateNestingComplexity(checkFile);
		assertEquals(15, cn);
		assertNotEquals(16, cn);
	}

}
