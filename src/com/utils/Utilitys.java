package com.utils;

import java.util.Scanner;

public class Utilitys {
    public static String actionVerification (Scanner reader, String actionToConfirm){//method to verification if you want to execute another method
        System.out.println("Are you sure you want to " + actionToConfirm + " (Y/N)");
        String verification = reader.next();
        if(verification.equals("Y")){
            return verification;
        } else {
            verification = "N";
            return verification;
        }
    }//met
}