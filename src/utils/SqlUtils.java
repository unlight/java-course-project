package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import phonebook.Application;

/**
 * @author S
 */
public class SqlUtils {

	public static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;

		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

	public static boolean transaction() {
		Connection connection = Application.connection();
		try {
			if (connection.getAutoCommit()) {
				connection.setAutoCommit(false);
			}
		} catch (SQLException ex) {
			Application.handleException(ex);
			return false;
		}
		return true;
	}

	public static boolean commit() {
		Connection connection = Application.connection();
		try {
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException ex) {
			Application.handleException(ex);
			return false;
		}
		return true;
	}

	public static void closeConnection() throws SQLException {
		Application.connection().close();
	}

	public static int insert(Object query) {
		try {
			String sql = query.toString();
			Statement statement = Application.connection().createStatement();
			statement.executeUpdate(sql);
			ResultSet rs = statement.executeQuery("select last_insert_rowid()");
			rs.next();
			int id = rs.getInt(1);
//            closeConnection();
			return id;
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
		return 0;
	}

	public static void update(Object query) {
		String sql = query.toString();
		try {
			Statement statement = Application.connection().createStatement();
			statement.executeUpdate(sql);
//            closeConnection();
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
	}

	public static ResultSet executeQuery(Object query) {
		ResultSet rs = null;
		try {
			Statement statement = Application.connection().createStatement();
			rs = statement.executeQuery(query.toString());
//            closeConnection();
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
		return rs;
	}

	public static Object getCell(Object query) {
		try {
			ResultSet rs = executeQuery(query);
			if (rs.next()) {
				return rs.getObject(1);
			}
		} catch (SQLException ex) {
			Application.handleException(ex);
		}
		return null;
	}

	public static List resultSetToArrayList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			HashMap row = new HashMap(columns);
			for (int i = 1; i <= columns; ++i) {
				row.put(md.getColumnName(i), rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}
}
