package com.example.whatsappintegrationmicroservice.dao;

import com.example.whatsappintegrationmicroservice.database.*;
import com.example.whatsappintegrationmicroservice.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository
{
    private static String userTable = "userTable";
    private static String msgTable = "messageTable";

    public static int creatUserTable(Connection connection)
    {
        return new TableOperation().creatTable(connection, userTable, "(userID int(50) PRIMARY KEY NOT NULL AUTO_INCREMENT, userName varchar(20), phoneNumber varchar(20), Email varchar(30), birthday Date, joinDate Date, password varchar(50))");
    }

    public static int getNextUserID(Connection connection)
    {
        ResultSet resultSet = new JdbcCRUD().searchData(connection, "table_name, AUTO_INCREMENT", "information_schema.tables", "table_name='"+ userTable +"'");
        while (true)
        {
            try
            {
                if (!resultSet.next())
                    break;
                return resultSet.getInt("AUTO_INCREMENT") - 1;
            }
            catch (SQLException e)
            {
                return -1;
            }
        }
        return -1;
    }

    public static boolean addNewRecord(Connection connection, User user, String password)
    {
        int result = new JdbcCRUD().insertData(connection,
                "`"+ userTable +"`",
                "(`userName`, `phoneNumber`, `email`, `birthday`, `joinDate`, `password`)",
                "('" + user.getUserName() + "', '" + user.getPhoneNumber() + "','"+ user.getEmail() + "','" + user.getBirthday() + "','" + user.getJoinDate() + "','" + password +"')");
        if (result == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static User login(Connection connection, String emailOrPhone, String password)
    {
        ResultSet resultSet = searchRecords(connection, "(email='"+emailOrPhone+"' OR phoneNumber = '" + emailOrPhone +"')AND password='"+password+"'");
        if(resultSet!=null)
        {
            User user = null;
            while (true)
            {
                try
                {
                    if(! resultSet.next() )
                    {
                        break;
                    }
                    else
                    {
                        user = new User();
                        user.setUserID(Integer.parseInt(resultSet.getString("userID")));
                        user.setUserName(resultSet.getString("userName"));
                        user.setEmail(resultSet.getString("email"));
                        user.setPhoneNumber(resultSet.getString("phoneNumber"));
                        user.setBirthday(resultSet.getString("birthday"));
                        user.setJoinDate(resultSet.getString("JoinDate"));
                    }
                }
                catch (SQLException e)
                {
                    throw new RuntimeException(e);
                }
            }
            return user;
        }
        return null;
    }



    public static ResultSet getAllRecords(Connection connection)
    {
        return new JdbcCRUD().getAllData(connection, "*", userTable);
    }

    public static ResultSet searchRecords(Connection connection, String whereCondition)
    {
        return new JdbcCRUD().searchData(connection,"*", userTable, whereCondition);
    }

    public static Boolean deleteRecords(Connection connection, String whereCondition)
    {
        int result = new JdbcCRUD().deleteData(connection, userTable, whereCondition);
        if( result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static Boolean updateRecords(Connection connection, String whereCondition, User user)
    {
        int result = new JdbcCRUD().updateData(connection, userTable, "", whereCondition);
        if( result!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
