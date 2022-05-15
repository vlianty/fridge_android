package com.example.fridge_app;

public class Goods {
    int g_Id;
    GoodsType g_Type;
    String g_Image;
    String g_Name;

    Goods(int g_Id, GoodsType g_Type, String g_Image, String g_Name)
    {
        this.g_Id = g_Id;
        this.g_Type = g_Type;
        this.g_Image = g_Image;
        this.g_Name = g_Name;
    }
}
