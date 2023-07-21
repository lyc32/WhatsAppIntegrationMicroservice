package com.example.whatsappintegrationmicroservice.database;

import java.sql.Connection;

public interface TableOperationInterface
{
    public int creatTable(Connection connection, String tableName, String valueList);
    public Boolean resetTable(Connection connection, String tableName);
    public Boolean dropTable(Connection connection, String tableName);
}
