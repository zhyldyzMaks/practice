package utils.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBC_Practice {

    public static void main(String[] args) throws SQLException {

        /*
        Connection --> it helps to provide DB credentials and connect to the DB itself
        Statement  --> we define our conditions to get the result from database
        ResultSet  --> we execute the SQL query and store the output from database to the ResultSet object in Java

        Three of them are interfaces.
         */

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@codefishdatabase-1.cfxmtijfjb4b.us-east-2.rds.amazonaws.com:1521/ORCL",
                "student",
                "codefish385"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet =statement.executeQuery("select * from employees");

        System.out.println(resultSet.next()); // it will go to the next row in the result set, and it will return TRUE and go to the next row

        System.out.println(resultSet.getString(3));//providing the index for getString() method will take the column value on that index

        System.out.println(resultSet.getString("first_name"));//getString() method can also accept the column name as a String

        resultSet.next();
        System.out.println(resultSet.getString("first_name"));

        resultSet.last(); // it will give me the last row from result set
        //resultSet.first(); -> will go to the frits row
        //resultSet.beforeFirst(); -> will go to the header/column name rows

        System.out.println(resultSet.getString("last_name"));
        System.out.println(resultSet.getRow());//will return me row number where my resultSet is pointed to

        resultSet.beforeFirst();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        //METADATA -> data about data, information about your columns, rows etc in your table.
        //a set of data describes and provides info about some other data (in our case it's a table)

        System.out.println(resultSetMetaData.getColumnCount());//12 columns
        System.out.println(resultSetMetaData.getColumnName(1));//employee_id

        for (int i = 1;i <= resultSetMetaData.getColumnCount(); i++){
            System.out.println(resultSetMetaData.getColumnName(i));
        }

        List<Map<String, Object>> employeesData = new ArrayList<>();

        resultSet.beforeFirst();//to go to the header row before we start iterating through the result set record

        while(resultSet.next()){
            Map<String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount();i++){
                employee.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
            }
            employeesData.add(employee);
        }
        System.out.println("=================================");
        System.out.println(employeesData.get(2).get("EMAIL"));


        //to get some certain value from the table
        for (int i = 0; i < employeesData.size();i++){
            System.out.println(employeesData.get(i).get("FIRST_NAME").toString() + " "+ employeesData.get(i).get("LAST_NAME").toString()
            + " "+ employeesData.get(i).get("SALARY").toString());
        }

    }
}
