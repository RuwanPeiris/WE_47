package complexity_measuring_tool.model;

import java.util.ArrayList;
import java.util.Date;

/*
 * @Author Peiris.M.R.P
 * IT16173064
 * 
 * This model class can use for file manipulation purpose
 */
public class CheckFile {
	
	String fileName;
	ArrayList<ViewRecord> fileLines;//File line by line save it the ViewRecord ArrayList object to manipulate values
	Date date;//Helps to manipulate date if any file records need to save
	int cs;//Set complexity of statement value here 
	int cns;//Set complexity of nesting statement value here
	int cts;//Set complexity of type of the statement value here
	int ci;//Set complexity of inheritance value here
	int cr;//Set complexity of recursion value here
	int tw;//File total complexity
	int cps;
	
	public CheckFile() {
	}
	
	public CheckFile(String fileName, ArrayList<ViewRecord> fileLines, Date date) {
		super();
		this.fileName = fileName;
		this.fileLines = fileLines;
		this.date = date;
	}

	
	public CheckFile(String fileName, ArrayList<ViewRecord> fileLines, Date date, int cs, int cns, int cts, int ci, int cr,
			int tw, int cps) {
		super();
		this.fileName = fileName;
		this.fileLines = fileLines;
		this.date = date;
		this.cs = cs;
		this.cns = cns;
		this.cts = cts;
		this.ci = ci;
		this.cr = cr;
		this.tw = tw;
		this.cps = cps;
	}

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ArrayList<ViewRecord> getFileLines() {
		return fileLines;
	}
	public void setFileLines(ArrayList<ViewRecord> fileLines) {
		this.fileLines = fileLines;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public int getCs() {
		return cs;
	}

	public void setCs(int cs) {
		this.cs = cs;
	}

	public int getCns() {
		return cns;
	}

	public void setCns(int cns) {
		this.cns = cns;
	}

	public int getCts() {
		return cts;
	}

	public void setCts(int cts) {
		this.cts = cts;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getCr() {
		return cr;
	}

	public void setCr(int cr) {
		this.cr = cr;
	}

	public int getTw() {
		return tw;
	}

	public void setTw(int tw) {
		this.tw = tw;
	}

	public int getCps() {
		return cps;
	}

	public void setCps(int cps) {
		this.cps = cps;
	}
	
	
	
}
