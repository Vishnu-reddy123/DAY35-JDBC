import java.sql.*;

public class EmployeePayrollService6 {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll DB");
        String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Vivare@*123";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            String sql = "INSERT INTO employee_payroll VALUES(4,'vishwak','4500000','2020-03-15','Male')";
            Statement statement = connection.prepareStatement(sql);
            statement.execute(sql);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee_payroll");
            System.out.println();
            System.out.println("id\t\tName\t\tbasic_pay\t\tStartDate\tGender");
            System.out.println("----------------------------------------------------------------");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t"
                        + resultSet.getString(2) + "\t\t\t"
                        + resultSet.getString(3) + "\t\t\t"
                        + resultSet.getString(4) + "\t\t"
                        + resultSet.getString(5));
            }
            connection.commit();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.getStackTrace();
        }
    }

}
