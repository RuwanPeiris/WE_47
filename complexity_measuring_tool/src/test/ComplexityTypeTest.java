package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import complexity_measuring_tool.service.ComplexityType;
import complexity_measuring_tool.util.CommonParams;

class ComplexityTypeTest {
	
	String fileName = "BrandController.java";
	File requestFile = new File(CommonParams.LOCAL_TEST_FILE_FOLDER_PATH + fileName);

	@Test
	void test() {
		int cn = 0;
//		cn = ComplexityType.calculateCts(requestFile);
		assertEquals(9, cn);
		assertNotEquals(10, cn);
	}

}
