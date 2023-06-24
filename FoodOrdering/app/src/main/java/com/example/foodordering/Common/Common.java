package com.example.foodordering.Common;

import com.example.foodordering.Model.User;

public class Common {

    public static User currentUser;
    public static String convertCodeToStatus(String status)
    {
        if(status.equals("0"))
        {
            return "Comanda Plasata";
        }
        else
        if(status.equals("1"))
            return "Comanda in curs de livrare";
        else
            return "Livrata";
    }



}
