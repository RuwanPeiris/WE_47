package complexity_measuring_tool.service;

/*
 * @Author Nimesh
 */
public class ComplexityType {

	public static int calculateCts(String line) {

		String[] words = null; // Intialize the word Array

		String s = line;
		String input1 = "if"; // Input word to be searched
		String input2 = "&&", input3 = "&";
		String input4 = "||", input5 = "|";
		String input6 = "while", input7 = "for";
		String input8 = "catch", input9 = "switch";

		int count = 0; // Intialize the word to zero
		if (s != null) {
			words = s.split("\\s"); // Split the word using space
			for (String word : words) {
				if (word.equals(input1)) // Search for the given word
				{
					count++; // If Present increase the count by one
					System.out.println("Type if found................." + count);
				} else if (word.equals(input2) || word.equals(input3)) {
					count++; // If Present increase the count by one
					System.out.println("Type && found................." + count);
				} else if (word.equals(input4) || word.equals(input5)) {
					count++; // If Present increase the count by one
					System.out.println("Type || found................." + count);
				} else if (word.equals(input6)) {
					count = count + 2;
					System.out.println("Type while found.............." + count);
				} else if (word.equals(input7)) {
					count = count + 2;
					System.out.println("Type for found................." + count);
				} else if (word.equals(input8)) {
					count++;
					System.out.println("Type catch found..............." + count);
				} else if (word.equals(input9)) {
					for (int i = 0; i < 3; i++) {
						count++;
					}
					System.out.println("Type switch found.............." + count);
				}
			}

		}
		if (count != 0) // Check for count not equal to zero
		{
			System.out.println("The Ctc value " + count + ".");
		} else {
			System.out.println("The given word is not present in the file");
		}
		
		return count;
	}

}
