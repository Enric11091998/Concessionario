package com.controller;

import com.model.Car;
import com.model.DataBase;



import java.util.Scanner;

public class CarController {

    public static void searchCar(Scanner reader){
        Car car;
        System.out.println("car license");
        String carlicense = reader.next();
        boolean c = DatabaseController.searchCarsTrueOrFalse(carlicense);
        if(c){
            int w = DatabaseController.searchCars(carlicense);
            car =  DataBase.getCars().get(w);
            System.out.println(car);
                    }
        else System.out.println("this carlicense no exists");
                    }

    public static void deleteCar(Scanner reader){
        DataBase db = new DataBase();
        Car car;
        System.out.println("car license");
        String carlicense = reader.next();
        boolean c = DatabaseController.searchCarsTrueOrFalse(carlicense);
        if(c){
            int w = DatabaseController.searchCars(carlicense);
            car =  DataBase.getCars().get(w);
            System.out.println(" this " + car + "is deleted");
            DataBase.getCars().remove(car);
                }
        else System.out.println("this carlicense no exists");
    }
}
