import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcExample {
    public static void main(String[] args) {
        try (Connection connection = MySqlDemo.getConnection()) {
            // 创建PreparedStatement对象
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM sys_user");
            // 执行SQL语句
            ResultSet resultSet = preparedStatement.executeQuery();

            // 处理结果集
            while (resultSet.next()) {
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("email");

                System.out.println(name + " " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class MySqlDemo {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加载JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 数据库连接参数
            String url = "jdbc:mysql://192.168.40.40:3306/test";
            String user = "pgsensing";
            String password = "pg123456";

            // 创建连接对象
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
