package complexity_measuring_tool.service;

import java.util.ArrayList;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.util.MyStack;

public class ComplexityHistoryForLine {

	// Create your variables here
	static int cs = 0;// OK
	static int ci = 0;// OK
	static int ctc = 0;// OK
	static int cns = 0;// OK
	static int tw = 0;
	static int cr = 0;
	static int cps = 0;

	public static CheckFile calculate(CheckFile checkFile) {

		ArrayList<ViewRecord> viewRecords = new ArrayList<ViewRecord>();
		final MyStack myStack = new MyStack();
		if (checkFile != null) {
			// Check line by line in the file
			for (ViewRecord viewRecord : checkFile.getFileLines()) {
				if (viewRecord.getValue() != null) {
					ci = ComplexityInheritance.calculateCi(viewRecord.getValue());
					cns = ComplexityNesting.calculateNestingComplexity(viewRecord.getValue(), myStack);
					ctc = ComplexityType.calculateCts(viewRecord.getValue());
					cs = ComplexityCs.calculateCs(viewRecord.getValue());
					// tw = calculate this one here
					// cr = ComplexityRecur.calculateCr(viewRecord.getValue());
					// cps = ComplexityCps.calculatecps(viewRecord.getValue());

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

			resetStaticVariables();
		}
		return checkFile;
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
