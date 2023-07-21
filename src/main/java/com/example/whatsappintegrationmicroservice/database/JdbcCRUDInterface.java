package com.example.whatsappintegrationmicroservice.database;

import java.sql.Connection;
import java.sql.ResultSet;

public interface JdbcCRUDInterface
{
    public ResultSet searchData(Connection connection, String columList, String tableName, String whereCondition);
    public ResultSet getAllData(Connection connection, String columList, String tableName);
    public int insertData(Connection connection, String tableName, String columList, String valueList);
    public int deleteData(Connection connection, String tableName, String whereCondition);
    public int updateData(Connection connection, String tableName, String valueList, String whereCondition);
}
