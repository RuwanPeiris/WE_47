package complexity_measuring_tool.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @author Tharindu
 */
public class ComplexityCs {
	
	public static int calculateCs(String line) {
		int lineNo = 0;
		int Cs1 = 0;
		int Cs2 = 0;
		int Cs = 0;
		
		if(line != null ) {
			line = line.trim();
			line.toLowerCase();
			
			if(!line.trim().equals("")) {
				
				lineNo++;
				System.out.println("Line " +lineNo+ " : " +line);
				
			    Pattern P1 = Pattern.compile("[0-9]|if\\(.*\\)|\\+{1,2}|\\-{1,2}|\\*|\\/|%|={1,2}|[<>=!]=?|[&|!]=?|[~^:]=?|\\\".*\\\"|void|double|int|float|string|printf|println|cout|cin|switch\\(.*\\)|case.*:|while\\(.*\\)|do\\{|abstract|assert|boolean|break|byte|catch|class|continue|default|enum |extends|final|finally|implements|import|instanceof|interface|long|native|null|package|static|strictfp|super|synchronized|transient|volatile");
			    Matcher M1 = P1.matcher(line);
			    if(M1.find()) {
				  Cs1++; 
			   }
			    
			    Pattern P2 = Pattern.compile("new|delete|throw|throws");
			    Matcher M2 = P2.matcher(line);
			    if(M2.find()) {
				  Cs2 = Cs2+2; 
			   }
			}
		}
		Cs = Cs1+Cs2;
		System.out.println("\n");
		System.out.println("Total Cs : " +Cs);
		System.out.println("\n");
		System.out.println("Cs2 : " +Cs2);
		System.out.println("Cs1 : " +Cs1);
		
		return Cs;
		
	}

}
