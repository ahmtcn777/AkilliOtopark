import java.sql.*;


public class DbParkYeri {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost/akilliotopark";

    static final String USER = null;
    static final String PASS = null;

    public void databaseDegistir(String sql) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://localhost/akilliotopark", "root", "");
        statement = connection.createStatement();

        statement.executeUpdate(sql);
        connection.close();
    }

    public int durumCek(String sql,String sutun) throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://localhost/akilliotopark", "root", "");
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        int durum = 0;
        while (resultSet.next()){
            durum = resultSet.getInt(sutun);
        }

        statement.close();
        connection.close();
        return durum;
    }
}
