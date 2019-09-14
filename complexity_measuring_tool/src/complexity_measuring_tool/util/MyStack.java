package complexity_measuring_tool.util;

import java.util.ArrayList;
/*
 * @Author Peiris.M.R.P
 * IT16173064
 */
public class MyStack {
	
	private int topCount;
	private ArrayList<String> lineArray;
	
	//Initializing stack
	public MyStack(){
		topCount = -1;
		lineArray = new ArrayList<String>();
	}
	
	//Push one line to stack
	public void push(String line) {
		topCount++;
		lineArray.add(line);
	}
	
	//Pop/remove one line from stack
	public String pop() {
		String topOne= lineArray.remove(topCount);
		topCount--;
		return topOne;
	}
	
	//Find top most placed/last entered line count, 
	//topCount initialized with -1 because it is an array insertion 0 is the first index and 0 th index stack count is 1
	public int peek() {
		return topCount+1; 
	}
}
