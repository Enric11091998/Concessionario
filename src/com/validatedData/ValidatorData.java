package com.validatedData;

import java.util.Scanner;


public class ValidatorData {
    public static void main(String[] args) {
    }

    public static void checkDNI() {
        String patternDNI = "^[0-9]{8}+[A-Z]{1}$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternDNI)){
            System.out.println("INVALID DNI!!.Please INSERT a valid DNI");
        }
    }

    public static void checkAge() {
        String patternAge= "^1[89]|[2-4][0-9]|5[0-5]$?-i";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternAge)){
            System.out.println("INVALID AGE!!.Please INSERT a valid AGE");
        }
    }

    public static void checkPhone() {
        String patternPhone= "^[6-7]{1}[0-9]{8}$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternPhone)){
            System.out.println("INVALID PHONE!!.Please INSERT a valid PHONE");
        }
    }

    public static void checkColorCar() {
        String patternColorCar= "^(?i:White|Grey|Black|Silver|Blue|Red|Beige|Green|Yellow)$";
        //Pattern p = Pattern.compile(patternPhone,Pattern.UNICODE_CASE);
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternColorCar)){
            System.out.println("INVALID COLOR!!.Please INSERT a valid COLOR");
        }
    }

    public static void checkCarBrand() {
        String patternCarBrand= "^(?i:BMW|MercedesBenz|Audi|Lexus|Renault|Ford|Opel|Seat|Honda|Toyota|Nissan|Hyundai|Kia|Chevrolet|Volkswagen)$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternCarBrand)){
            System.out.println("INVALID BRAND CAR!!.Please INSERT a BRAND CAR");
        }
    }

    public static void checkNumberCard() {
        String patternNumberCard= "^([4][0-9]{15}|5[1-5][0-9]{14})$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternNumberCard)){
            System.out.println("INVALID NUMBER CARD!!.Please INSERT a NUMBER CARD");
        }
    }

    public static void checkExpirationCard() {
        String patternExpirationCard= "^(([0][1-9]|[1][0-2])20[2-9]{2})$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patternExpirationCard)){
                System.out.println("INVALID EXPIRATION CARD!!.Please INSERT a EXPIRATION CARD");
        }
    }

    public static void checkSecurityCodeCard() {
        String patterSecurityCodeCard= "^([0-9]{3})$";
        Scanner reader = new Scanner(System.in);
        while (!reader.next().matches(patterSecurityCodeCard)){
            System.out.println("INVALID SECURITY CODE!!.Please INSERT a SECURITY CODE");
        }
    }

}
