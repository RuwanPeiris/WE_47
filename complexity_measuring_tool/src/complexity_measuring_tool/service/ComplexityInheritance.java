package complexity_measuring_tool.service;


import complexity_measuring_tool.util.CommonParams;

/*
 * @author Peiris.M.R.P
 * IT16173064
 */
public class ComplexityInheritance {


	public static int calculateCi(String line) {
		
		int complexityInheritanceValue = 0;

		line.trim();// removing spaces leading and trailing in a line
		if (line.contains("class ") || line.contains("interface ")) {
			complexityInheritanceValue += 2;// Class or interface complexity default value is 2
			if (line.contains("extends ")) {
				complexityInheritanceValue += 1;// Always extends have one super class increment by 1
			}
			if (line.contains("implements ")) {
				String[] splitted = line.split("implements ");
				String keyWordAfterString = splitted[CommonParams.ARRAY_SECOND_ELEMENT];// Put implemented interfaces to String array
				String[] beforCurly = keyWordAfterString.split("\\{");// Removing {
				if (beforCurly.length > 0) {// Check weather that have interfaces > 0
					String[] implementedSuper = beforCurly[CommonParams.ARRAY_FIRST_ELEMENT].split(",");// Interfaces put in to the String array
					for (int i = 0; i < implementedSuper.length; i++) {
						complexityInheritanceValue += 1;// Increase complexity by one once found inherited interface
						System.out.println(
								"This class implemented interface " + (i + 1) + " by " + implementedSuper[i].trim());
					}
				}
			}
		}
		
		return complexityInheritanceValue;
	}

}
