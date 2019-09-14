package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewFile;
import complexity_measuring_tool.util.DBConnection;
/*
 * @author Peiris.M.R.P
 * IT16173064
 */
public class FileAccess {

	public static boolean saveFileData(CheckFile checkFile)
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		Connection connection = DBConnection.getInstance().getConnection();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String dateTime = df.format(checkFile.getDate());

		String sql = "Insert into file values(" + 0 + ",'" + checkFile.getFileName() + "','" + dateTime +"')";

		Statement statement = connection.createStatement();
		int resp = statement.executeUpdate(sql);

		if (resp > 0) {
			ResultSet rs = statement.getGeneratedKeys();
			int lastInsertedRecoedId = 0;
			if (rs.next()) {
				lastInsertedRecoedId = rs.getInt(1);
			}
			boolean res = RecordAcess.saveRecordData(lastInsertedRecoedId, checkFile);
			if (res == true) {
				return true;
			}else {
				connection.rollback();
				return false;
			}
		}
		connection.rollback();
		return false;
		
	}
	
	public static ArrayList<ViewFile> retiveOldFileData()
			throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "SELECT * FROM file";
		
		ArrayList<ViewFile> latesFiles = new ArrayList<ViewFile>();
		try {
			connection = DBConnection.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs= statement.executeQuery(sql);
			ViewFile viewFile=null;
			while (rs.next()) {
				viewFile = new ViewFile(rs.getString("fileName"), rs.getString("date"),rs.getInt("cs"),rs.getInt("cns"),rs.getInt("cts"),rs.getInt("ci"),rs.getInt("cr"),rs.getInt("tw"),rs.getInt("cps"));
				latesFiles.add(viewFile);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return latesFiles;
		
	}
	
	

}
