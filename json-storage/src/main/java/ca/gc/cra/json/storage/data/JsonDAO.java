package ca.gc.cra.json.storage.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class JsonDAO {
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM records";
	private static final String SQL_INSERT_DATA = "INSERT INTO records (data) VALUES(";
	private static final String SQL_INSERT_DATA_END = ")";
	
	private static final String DB_TYPE = "jdbc:postgresql";
	private static final String DB_HOST = "errorpostgresql"; //"errorpostgresql-eda-epayroll-poc.apps.ocp4.omega.dce-eir.net"
	private static final String DB_PORT = "5432";
	
	private static final String BACKUP_DB_NAME = "jsondb";
	private static final String BACKUP_USER_NAME = "yuriy";
	private static final String BACKUP_PASSWORD = "1234";
	
	private Connection getConnection() {
		
		String dbName = System.getenv("DB_NAME");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");
    
		if (dbName == null) {
			dbName = BACKUP_DB_NAME;
			user = BACKUP_USER_NAME;
			password = BACKUP_PASSWORD;
		}
		
		String url = DB_TYPE + "://" + DB_HOST + ":" + DB_PORT + "/" + dbName;
		
		System.out.println("Connecting: " + url + " using: " + user);
		
		Connection connection = null;
    
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Failed to connect to DB");
			e.printStackTrace();
		}
    
		return connection;
	}
	
	public List<JsonRecord> getAllJsonRecords() {
		List<JsonRecord> result = new ArrayList<>();

		Connection connection = getConnection();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(SQL_SELECT_ALL);

				while (rs.next()) {
					JsonRecord record = new JsonRecord();
					record.setId(rs.getLong(1));
					record.setJson(new JSONObject(rs.getString(2)));

					result.add(record);
				}

			} catch (SQLException e) {
				System.out.println("Failed to execute SELECT");
				e.printStackTrace();
			}
		}

		return result;
	}

	public boolean saveJsonRecord(JSONObject data) {
		boolean result = false;
		
		Connection connection = getConnection();

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
                statement.executeUpdate(
                		SQL_INSERT_DATA + 
                		data.toString() + 
                		SQL_INSERT_DATA_END);
				
			} catch (SQLException e) {
				System.out.println("Failed to execute INSERT");
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
