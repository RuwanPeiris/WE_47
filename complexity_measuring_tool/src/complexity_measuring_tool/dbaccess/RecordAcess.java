package complexity_measuring_tool.dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import complexity_measuring_tool.model.CheckFile;
import complexity_measuring_tool.model.ViewRecord;
import complexity_measuring_tool.util.DBConnection;

/*
 * @author Peiris.M.R.P IT16173064
 * 
 */
public class RecordAcess {

	public static boolean saveRecordData(int fileId, CheckFile checkFile) {

		Connection connection = null;
		boolean res = false;

		try {
			connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false);
			PreparedStatement statement = connection.prepareStatement("INSERT INTO records values(?,?,?,?,?,?,?,?,?,?)");
			
			for (ViewRecord viewRecord : checkFile.getFileLines()) {
				statement.setObject(1, 0);
				statement.setObject(2, viewRecord.getValue());
				statement.setObject(3, fileId);
				statement.setObject(4, viewRecord.getCs());
				statement.setObject(5, viewRecord.getCns());
				statement.setObject(6, viewRecord.getCts());
				statement.setObject(7, viewRecord.getCi());
				statement.setObject(8, viewRecord.getCr());
				statement.setObject(9, viewRecord.getTw());
				statement.setObject(10, viewRecord.getCps());
				statement.addBatch();
			}
			int[] result = statement.executeBatch();

			if (result.length > 0) {
				connection.commit();
				res = true;
			} else {
				connection.rollback();
				res = false;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return res;
	}

	public static ArrayList<ViewRecord> retriveRecords(String fileName) {
		String sql = "select r.value,f.date,r.cs,r.cns,r.cts,r.ci,r.cr,r.tw,r.cps " + "from records r, file f "
				+ "where f.fileId=r.fileId and r.fileId = (" + "select fl.fileId " + "from file fl "
				+ "where fileName='" + fileName + "' " + "group by fl.fileId desc " + "limit 1)";

		Connection connection = null;
		ArrayList<ViewRecord> latesRecords = new ArrayList<ViewRecord>();

		try {
			connection = DBConnection.getInstance().getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			ViewRecord line = null;
			while (rs.next()) {
				line = new ViewRecord(rs.getString("date"), rs.getString("value"), rs.getInt("cs"), rs.getInt("cns"),
						rs.getInt("cts"), rs.getInt("ci"), rs.getInt("cr"), rs.getInt("tw"), rs.getInt("cps"));
				latesRecords.add(line);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return latesRecords;
	}
}
