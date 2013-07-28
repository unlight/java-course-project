package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.UIManager;
import phonebook.ui.MainFrame;
import utils.StringUtils;

public class Application {

	private String name = "Phonebook";
	private String version = "1.2.0";
	private String datafile = "./phonebook.dat";
	private Connection connection;
	public MainFrame frame;
	private static Application application;

	public static Application getInstance() {
		if (application == null) {
			application = new Application();
			application.bootstrap();
		}
		return application;
	}

	public static Connection connection() {
		try {
			return Application.getInstance().getConnection();
		} catch (SQLException ex) {
			handleException(ex);
		}
		return null;
	}

	public void bootstrap() {
		try {
			// Подключение.
			Class.forName("org.sqlite.JDBC");
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        connection.setAutoCommit(false);
		} catch (Exception e) {
			handleException(e);
		}
		// Создаем/обновляем структуру базы данных.
		Structure structure = new Structure();
		structure.update();
	}

	/**
	 * Общий обработчик исключений.
	 *
	 * @param e [description]
	 */
	public static void handleException(Exception e) {
		e.printStackTrace();
//        Application app = getInstance();
//        JOptionPane.showMessageDialog(null, e.toString(), e.toString(), JOptionPane.ERROR_MESSAGE);
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			handleException(e);
		}
	}

	public static Connection staticGetConnection() throws SQLException {
		return getInstance().getConnection();
	}

	public Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection("jdbc:sqlite:" + datafile);
		}
		return connection;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setMainFrame(MainFrame f) {
		frame = f;
		frame.setTitle(StringUtils.join(new String[]{name, version}, " "));
	}
}