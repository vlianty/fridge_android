package com.example.fridge_app;

import java.sql.*;
public class TemperatureSensorDBver {
    double getFahrenheit(int fridgeNum)
    {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sa", "root", "");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM `temperature_sensor` WHERE `f_num` ="+ fridgeNum);
            while (rs.next())
            {
                return rs.getFloat(4); //拿當前溫度(華氏)
            }
        } catch (Exception e) {

            return 0.0;
        }
        return 0.0;
    }

    double getCelsius(int fridgeNum)
    {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sa", "root", "");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM `temperature_sensor` WHERE `f_num` ="+ fridgeNum);
            while (rs.next())
            {
                return rs.getFloat(3); //拿當前溫度(攝氏)
            }
        } catch (Exception e) {

            return 0.0;
        }
        return 0.0;
    }
    double getHumidity(int fridgeNum)
    {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sa", "root", "");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM `temperature_sensor` WHERE `f_num` ="+ fridgeNum);
            while (rs.next())
            {
                return rs.getFloat(2); //拿當前濕度
            }
        } catch (Exception e) {

            return 0.0;
        }
        return 0.0;
    }
}
