package complexity_measuring_tool.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 * @author Dananji
 * 
 */
public class ComplexityRecursion {

	public static int calculateRecursion(String line,int cps,String[] filterdWord,String[] FinalfilterdWord) {

		String line1 = line; 
		String word;
		int count = 0;
		int Rcount = 0;
		int recurciveValue = 0;

//		String[] filterdWord = new String[9999];
//		String[] FinalfilterdWord = new String[9999];

		if (line1 != null) {
			line1 = line1.trim();
			if (!line1.trim().equals("")) {
				count++;
				// System.out.println("Line " +count+ ":" +line);
				Pattern P = Pattern.compile(
						"int.*\\(.*\\)|char.*\\(.*\\)|void.*\\(.*\\)|double.*\\(.*\\)|string.*\\(.*\\)|float.*\\(.*\\)");
				Matcher M = P.matcher(line1);
				if (M.find()) {
					// System.out.println(M.group());
					filterdWord = M.group().split("int|char|String|double|float|void", 2);

					for (String s : filterdWord) {
						// System.out.println(s);
						FinalfilterdWord = s.split("\\(.*\\)", 2);
						for (String v : FinalfilterdWord) {
							if (!v.isBlank()) {
								if (line1.contains(v)) {
									recurciveValue += cps*2;
									System.out.println("recursion occ -> "+recurciveValue);
								}
							}
						}
					}
					/*
					 * Pattern P2 = Pattern.compile(v); Matcher M2 = P2.matcher(line); if(M2.find())
					 * { //CS*2 //System.out.println("recurrsion"); }
					 */
				}
			}
		}
		System.out.println("cr "+recurciveValue);
		return recurciveValue;
	}
}
