package complexity_measuring_tool.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.util.CommonParams;
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
		final String[] filterdWord = new String[9999];
		final String[] FinalfilterdWord = new String[9999];
		if (checkFile != null) {
			int tcs = 0;
			int tci = 0;
			int tctc = 0;
			int tcns = 0;
			int ttw = 0;
			int tcr = 0;
			int tcps = 0;
			final Pattern commentPattern = Pattern.compile(CommonParams.COMMENT_LINE);
			final Pattern elsePattern = Pattern.compile(CommonParams.REGEX_ELSE);
			final Pattern startCurlyPattern = Pattern.compile(CommonParams.LINE_STARTS_WITH_CURLY);
			final Pattern blockCommentPattern = Pattern.compile(CommonParams.BLOCK_COMMENT_LINE);
			final Pattern packagePattern = Pattern.compile(CommonParams.PACKAGE_REGEX);
			final Pattern importPattern = Pattern.compile(CommonParams.IMPORT_REGEX);
			final Pattern spacePattern = Pattern.compile("(\\s)+");
			// Check line by line in the file
			for (ViewRecord viewRecord : checkFile.getFileLines()) {
				Matcher commentMatcher = commentPattern.matcher(viewRecord.getValue());
				Matcher elseMatcher = elsePattern.matcher(viewRecord.getValue());
				Matcher startCurlyMatcher = startCurlyPattern.matcher(viewRecord.getValue());
				Matcher blockCommentMatcher = blockCommentPattern.matcher(viewRecord.getValue());
				Matcher packageMatcher = packagePattern.matcher(viewRecord.getValue());
				Matcher spaceMatcher = spacePattern.matcher(viewRecord.getValue());
				Matcher importMatcher = importPattern.matcher(viewRecord.getValue());
				if (viewRecord.getValue() != null) {
					ci += ComplexityInheritance.calculateCi(viewRecord.getValue());
					cns = ComplexityNesting.calculateNestingComplexity(viewRecord.getValue(), myStack);
					ctc = ComplexityType.calculateCts(viewRecord.getValue());
					cs = ComplexityCs.calculateCs(viewRecord.getValue());
					tw = ctc + cns + ci;
					cr = ComplexityRecursion.calculateRecursion(viewRecord.getValue(), cs, filterdWord,
							FinalfilterdWord);
					cps = cs * tw;

					if (commentMatcher.matches() | elseMatcher.matches() | startCurlyMatcher.matches()
							| viewRecord.getValue().contains("class ") | viewRecord.getValue().contains("interface ")
							| blockCommentMatcher.matches() | packageMatcher.matches() | importMatcher.matches()
							| viewRecord.getValue().isEmpty() | spaceMatcher.matches()) {
						viewRecord.setCi(0);
						viewRecord.setCns(0);
						viewRecord.setCts(0);
						viewRecord.setCs(0);
						viewRecord.setTw(0);
						viewRecord.setCr(0);
						viewRecord.setCps(0);
					} else {
						viewRecord.setCi(ci);
						viewRecord.setCns(cns);
						viewRecord.setCts(ctc);
						viewRecord.setCs(cs);
						viewRecord.setTw(tw);
						viewRecord.setCr(cr);
						viewRecord.setCps(cps);
					}
					viewRecords.add(viewRecord);

					tcs += cs;
					tci = ci;
					tctc += ctc;
					tcns += cns;
					ttw += tw;
					tcr += cr;
					tcps += cps;
				}
			}
			checkFile.setFileLines(viewRecords);
			checkFile.setCp(tcps);

			resetStaticVariables();
			resetStaticCi();
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
	
	public static void resetStaticCi() {
		ci = 0;
	}

}
