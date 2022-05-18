package com.example.fridge_app;

import android.util.Log;

import java.sql.*;

public class WeightSensorDBver {
    double getWeight(int drawerID)
    {
        Connection connection;
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sa", "root", "");
            //Class.forName("com.mysql.jdbc.Driver");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM `weight_sensor` WHERE `d_id` ="+drawerID);
            while (rs.next())
            {
                return rs.getFloat(4); //拿當前重量
            }
        } catch (Exception e) {

            return 0.0;
        }
        return 0.0;
    }
}
