package com.cybertek.tests;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {

    String oracleDbUrl="jdbc:oracle:thin:@ec2-18-212-177-138.compute-1.amazonaws.com:1521:xe";
    String oracleDbUsername="hr";
    String oracleDbPassword="hr";

    @Test
    public void oracleJDBC() throws SQLException {
        Connection connection= DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("select * from countries");

        resultSet.next();
        System.out.println(resultSet.getString(1));
        System.out.println(resultSet.getString("country_name"));
        System.out.println(resultSet.getString("region_id"));
//        while(resultSet.next()) {
//            System.out.println(resultSet.getString(1) + " " + resultSet.getString("country_name") + " " +
//                    resultSet.getString("region_id"));
//        }
        resultSet.next();
        System.out.println(resultSet.getRow());
        resultSet.next();
        resultSet.first();
        
        //find out how many records in the resultSet
       // resultSet.last();
        int rowsCount=resultSet.getRow();
        System.out.println("rowsCount = " + rowsCount);//current row





        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test()
    public void jdbcMetadata() throws SQLException {
        Connection connection= DriverManager.getConnection(oracleDbUrl, oracleDbUsername, oracleDbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql="select employee_id, last_name, job_id, salary from employees";
        ResultSet resultSet=statement.executeQuery(sql);
        
        DatabaseMetaData dbMetaData=connection.getMetaData();
        System.out.println("dbMetaData.getUserName() = " + dbMetaData.getUserName());
        System.out.println("dbMetaData.getDatabaseProductName() = " + dbMetaData.getDatabaseProductName());

        ResultSetMetaData rsMetaData=resultSet.getMetaData();
        System.out.println("Columns count: "+rsMetaData.getColumnCount());
        System.out.println(rsMetaData.getColumnName(1));

        for (int i = 1; i <=rsMetaData.getColumnCount(); i++) {
            System.out.println(i+"-->"+rsMetaData.getColumnName(i));
        }

        List<Map<String,Object>> list = new ArrayList<>();
        ResultSetMetaData rsMData=resultSet.getMetaData();
        int colCount=rsMData.getColumnCount();

        while (resultSet.next()){
            Map<String,Object> rowMap = new HashMap<>();
            for(int col=1; col<=colCount; col++){
                rowMap.put(rsMData.getColumnName(col),resultSet.getObject(col));
            }
            list.add(rowMap);
        }

        for (Map<String, Object> emp:list) {
            System.out.println(emp.get("EMPLOYEE_ID"));
        }





        resultSet.close();
        statement.close();
        connection.close();
    }
}
