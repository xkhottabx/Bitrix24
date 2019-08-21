package com.cybertek.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void establishConnection(DBType dbType) throws SQLException {
        switch (dbType){
            case ORACLE:
                connection= DriverManager.getConnection((ConfigurationReader.get("oracledb.url")),
                        (ConfigurationReader.get("oracledb.user")),
                        (ConfigurationReader.get("oracledb.password")));
                break;
            default:
                connection=null;

        }
    }

    public static int getRowsCount(String sql) throws SQLException {
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(sql);
        resultSet.last();
        return resultSet.getRow();
    }

    public static List<Map<String,Object>> runSQLQuery(String sql) throws SQLException {
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet=statement.executeQuery(sql);
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
        return list;
    }

    public static void closeConnections(){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


