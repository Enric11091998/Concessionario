package com.controller;

import com.model.Car;
import com.model.DataBase;
import com.utils.Utilitys;


import java.util.Scanner;

public class CarController {

    public static void searchCar(Scanner reader){
        Car car;
        String carLicense = Utilitys.askInfo(reader,"Enter a car license");
        boolean c = DatabaseController.searchCarsTrueOrFalse(carLicense);
        if(c){
            int w = DatabaseController.searchCars(carLicense);
            car =  DataBase.getCars().get(w);
            System.out.println(car);
                    }
        else System.out.println("this car license no exists");
                    }

    public static void deleteCar(Scanner reader){
        Car car;
        String carLicense = Utilitys.askInfo(reader,"Enter a car license");
        boolean c = DatabaseController.searchCarsTrueOrFalse(carLicense);
        if(c){
            int w = DatabaseController.searchCars(carLicense);
            car =  DataBase.getCars().get(w);
            System.out.println(" this " + car + "is deleted");
            DataBase.getCars().remove(car);
                }
        else System.out.println("this car License no exists");
    }
}
