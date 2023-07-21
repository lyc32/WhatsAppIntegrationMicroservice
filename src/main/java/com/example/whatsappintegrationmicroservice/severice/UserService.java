package com.example.whatsappintegrationmicroservice.severice;

import com.example.whatsappintegrationmicroservice.database.ConnectDB;
import com.example.whatsappintegrationmicroservice.model.User;
import com.example.whatsappintegrationmicroservice.dao.UserRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService
{
    private static Connection connection = null;
    private static int currentUserID = -1;

    public UserService(String driver, String url, String userName, String password)
    {
        if (connection == null)
        {
            ConnectDB connectDB = new ConnectDB(driver, url, userName, password);
            if (connectDB.connectToDataBase())
            {
                connection = connectDB.getConnection();
            }
        }
        if(connection!=null)
        {
            if(currentUserID < 0)
            {
                int result = UserRepository.creatUserTable(connection);
                if(result == 0)
                {
                    currentUserID = UserRepository.getNextUserID(connection);
                }
                else if(result == 1)
                {
                    currentUserID = 0;
                }
                else
                {
                    currentUserID = -1;
                }
            }
        }
    }

    public boolean signIn(User user, String password)
    {
        if(connection == null)
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return false;
        }
        if(currentUserID < 0)
        {
            System.out.println("[Sever Sync Error]: Can not Sync currentUserID from Database");
            return false;
        }
        if(!UserRepository.addNewRecord(connection, user, password))
        {
            System.out.println("[DataBase Insert Failed]: Can not insert new Record");
            return false;
        }
        else
        {
            currentUserID++;
            return true;
        }
    }

    public User login(String email, String password)
    {
        if(connection == null)
        {
            System.out.println("[DataBase Connection Error]: Can not access to the Database");
            return null;
        }

        return UserRepository.login(connection, email, password);
    }
}
