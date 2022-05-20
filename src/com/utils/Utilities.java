package com.utils;

import com.services.ValidatorData;

import java.util.Scanner;

public class Utilities {
    public static String actionVerification (Scanner reader, String actionToConfirm){//method to verification if you want to execute another method
        System.out.println("Are you sure you want to " + actionToConfirm + " (Y/N)");
        String verification = reader.next();
        if(verification.equals("Y")){
            return verification;
        }
        verification = "N";
        return verification;
    }//met
    public static String askInfo(Scanner reader,String info){
        ValidatorData vd = new ValidatorData();
        System.out.println(info);
        String data = reader.next();
        if(info.equals("Enter a dni")){
            String a = vd.checkDNI(data);
            return a;
        }else if(info.equals("Enter a car license")){
            String a = vd.checkCarLicence(data);
            return a;
        }else if(info.equals("Enter a Card number")){
            String a = vd.checkNumberCard(data);
            return a;
        }else if(info.equals("Enter an id Order")){
            String a = vd.checkIdOrder(data);
            return a;
        }
        return "0";
    }
}
