package com.example.foodorderingserver.Common;

import com.example.foodorderingserver.Model.User;

public class Common {
    public static User currentUser;
    public static final String UPDATE = "Update";
    public static final String DELTE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71;

    public  static String convertCodeToStatus(String code)
    {
        if(code.equals("0"))
        {
            return "Comanda plasata";
        }
        else if(code.equals("1"))
        {
            return "Comanda in curs de livrare";
        }
        else
            return "Livrata";
    }

}
