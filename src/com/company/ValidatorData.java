package com.company;

import java.util.Scanner;

public class ValidatorData {

    ValidatorData(){};

    public  String selectValidatorCustomerAndCard(String i, String b){
        String a = new String();
        switch (i){

            case "dni?":a = checkDNI(b);
                    break;
            case "name?":a= name(b);
                    break;
            case "surname?":a= surname(b);
                    break;
            case "age?":a= checkAge(b);
                    break;
            case "phone?": a= checkPhone(b);
                    break;
            case "favorite color car?":a =checkColorCar(b);
                    break;
            case "favorite brand car?":a = checkCarBrand(b);
                    break;
            case "numberCard?":a= checkNumberCard(b);
                    break;
            case "expiration?":a= checkExpirationCard(b);
                    break;
            case "type?":a =checkTypeCard(b);
                    break;
            case "securityCode?":a = checkSecurityCodeCard(b);
                    break;


        }
        return a;

    }

    public String selectValidatorEmployee(String i, String b){
        String a = new String();
        switch (i){

            case "dni?":a = checkDNI(b);
                break;
            case "name?":a= name(b);
                break;
            case "surname?":a= surname(b);
                break;
            case "age?":a= checkAge(b);
                break;
            case "rol?": a= checkRol(b);
                break;
            case "salary by month?":a =checkSalaryByMonth(b);
                break;
            case "worked hours?":a = checkWorkedHours(b);
                break;
            case "Confirm password","Enter password:\n1. Password must contain at least one digit [0-9].\n2. Password must contain at least one lowercase Latin character [a-z].\n3. Password must contain at least one uppercase Latin character [A-Z].\n4. Password must contain at least one special character like ! @ # & ( ) – { } : ; ' ? / * ~ $ ^ + = < >\n5. Password must contain a length of at least 6 characters and a maximum of 12 characters.": a=checkPassword(b);
                break;
            case "Confirm password?":a = checkPassword(b);
        }
        return a;

    }

    public  String checkDNI(String a) {
        String patternDNI = "^[0-9]{8}+[A-Z]{1}$";
        Scanner reader = new Scanner(System.in);
        while(!a.matches(patternDNI)){
            System.out.println("INVALID DNI!!.Please INSERT a valid DNI");
            a = reader.next();
        }
        return  a;

    }

    public  String name(String a) {
        return a;
    }

    public  String surname(String a) {
        return a;
    }

    public  String checkAge(String a) {
        String patternAge= "^1[89]|[2-4][0-9]|5[0-5]$";
        Scanner reader = new Scanner(System.in);
       while(!a.matches(patternAge)){
            System.out.println("INVALID AGE!!.Please INSERT a valid AGE");
            a = reader.next();
        }
        return  a;
    }

    public  String checkPhone(String a) {
        String patternPhone= "^[67][0-9]{8}$";
        Scanner reader = new Scanner(System.in);
        while(!a.matches(patternPhone) ){
            System.out.println("INVALID PHONE!!.Please INSERT a valid PHONE");
            a = reader.next();
        }
        return  a;
    }

    public  String checkColorCar(String a) {
        String patternColorCar= "^(?i:White|Grey|Black|Silver|Blue|Red|Beige|Green|Yellow)$";
        Scanner reader = new Scanner(System.in);
        while(!a.matches(patternColorCar)){
            System.out.println("INVALID COLOR!!.Please INSERT a valid COLOR");
            a = reader.next();
        }
        return  a;
    }

    public  String checkCarBrand(String a) {
        String patternCarBrand= "^(?i:BMW|MercedesBenz|Audi|Lexus|Renault|Ford|Opel|Seat|Honda|Toyota|Nissan|Hyundai|Kia|Chevrolet|Volkswagen)$";
        Scanner reader = new Scanner(System.in);
        while(!a.matches(patternCarBrand)){
            System.out.println("INVALID BRAND!!.Please INSERT a valid BRAND");
            a = reader.next();
        }
        return  a;
    }

    public  String checkNumberCard(String a) {
        String patternNumberCard= "^([4][0-9]{15}|5[1-5][0-9]{14})$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patternNumberCard)){
            System.out.println("INVALID NUMBER CARD!!.Please INSERT a NUMBER CARD");
            a = reader.next();
        }
        return a;
    }

    public  String checkExpirationCard(String a) {
        String patternExpirationCard= "^(([0][1-9]|[1][0-2])20[2-9]{2})$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patternExpirationCard)){
            System.out.println("INVALID EXPIRATION CARD!!.Please INSERT a EXPIRATION CARD");
            a = reader.next();
        }
        return a;
    }

    public  String checkTypeCard(String a) {
        return a;
    }

    public  String checkSecurityCodeCard(String a) {
        String patterSecurityCodeCard= "^([0-9]{3})$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patterSecurityCodeCard)){
            System.out.println("INVALID SECURITY CODE!!.Please INSERT a SECURITY CODE");
            a = reader.next();
        }return a;
    }

    public  String checkWorkHours(String a) {
        String patterSecurityCodeCard= "^(3[89]|4[0])$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patterSecurityCodeCard)){
            System.out.println("INVALID HOURS!!.Please INSERT a HOURS");
            a = reader.next();
        }
        return  a;

    }
    public String checkWorkedHours(String a) {
        String patterSecurityCodeCard= "^(3[89]|4[0])$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patterSecurityCodeCard)){
            System.out.println("INVALID HOURS!!.Please INSERT a HOURS");
            a = reader.nextLine();
            if(a.equals("null")){
                break;
            }
        }
        return a;
    }

    public  String checkPassword(String a) {
        String patternPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,12}$";
        Scanner reader = new Scanner(System.in);
        while (!a.matches(patternPassword)){
            System.out.println("INVALID PASSWORD!!.Please INSERT a valid PASSWORD");
            a = reader.nextLine();
        }

        return a;

    }
    public String checkSalaryByMonth(String a){
        return  a;
    }

    public String checkRol(String a){
        String patternRol= "^(?i:Employee|Manager)$";
        Scanner reader = new Scanner(System.in);
        while(!a.matches(patternRol)){
            System.out.println("INVALID ROL!!.Please INSERT a valid ROL");
            a = reader.next();
            if(a.equals("null")){
                break;
            }
        }
        return  a;
    }
}




