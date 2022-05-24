package com.controller;

import com.model.Car;
import com.model.DataBase;
import com.utils.Utilities;

import java.util.List;
import java.util.Scanner;

public class CarController {

    public static void searchCar(Scanner reader){
        Car car;
        String carLicense = Utilities.askInfo(reader,"Enter a car license");
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
        String carLicense = Utilities.askInfo(reader,"Enter a car license");
        boolean c = DatabaseController.searchCarsTrueOrFalse(carLicense);
        if(c){
            int w = DatabaseController.searchCars(carLicense);
            car =  DataBase.getCars().get(w);
            System.out.println(" this " + car + "is deleted");
            DataBase.getCars().remove(car);
                }
        else System.out.println("this car License no exists");
    }
    public static void printCars(List<Car> cars){
        for(int i = 0; cars.size() > i;i++)
        System.out.println(i + "--" + "Brand:" + cars.get(i).getBrand() + " || "
                + "number of doors:" + cars.get(i).getNumberOfDoors() + " || "
                + "color:" + cars.get(i).getColor() + " || "
                + "km:" + cars.get(i).getKm() + " || "
                + "carLicense:" + cars.get(i).getCarLicense() + " || "
                + "insurance:" + cars.get(i).getInsurance() + " || "
                + "price:" + cars.get(i).getPrice() + " || "
                + "year:" + cars.get(i).getYear() + ".");
    }

}
