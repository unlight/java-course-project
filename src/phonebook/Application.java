package phonebook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

    private String name = "Phonebook";
    private String version = "1.0.0";
    private String datafile = "./phonebook.dat";
    private Connection connection;
    public MainFrame frame;
    private static Application application;

    public static Application getInstance() {
	  if (application == null) {
		application = new Application();
	  }
	  return application;
    }

    public static Connection connection() {
	  return Application.getInstance().getConnection();
    }

    public void bootstrap() {
	  try {
		// Подключение.
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:" + datafile);
	  } catch (Exception e) {
		handleException(e);
	  }
	  // Создаем/обновляем структуру базы данных.
	  Structure structure = new Structure(connection);
	  structure.update();
    }

    /**
     * Общий обработчик исключений.
     *
     * @param e [description]
     */
    public static void handleException(Exception e) {
	  e.printStackTrace();
    }

    public void closeConnection() {
	  try {
		connection.close();
	  } catch (SQLException e) {
		handleException(e);
	  }
    }

    private Connection getConnection() {
	  return connection;
    }
}