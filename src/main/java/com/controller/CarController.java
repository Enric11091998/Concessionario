package com.controller;

import com.manager_persistences.PersistenceCEOCR;
import com.model.Car;
import com.services.ServicesCar;
import com.services.ValidatorData;

import java.util.List;
import java.util.Scanner;

public class CarController {

    public CarController(){

    }

    public void searchCarbyLincese(Scanner reader){
        System.out.println("Enter a license");
        String license = reader.next();
        Car car ;
        car =PersistenceCEOCR.find(license,3);
        if(car!= null){
            System.out.println(car);
        }else System.out.println("this car no exists");
    }

    public void searchCarbyColorandYear(Scanner reader){
        ValidatorData vd = new ValidatorData();
        System.out.println("Enter a color");
        String color = vd.checkColorCar(reader.next());
        System.out.println("Enter a year");
        String year = vd.checkCarYear(reader.next());
        List<Car> cars =PersistenceCEOCR.searchCarsbyOptions(color,"null",year,2);
        if(cars== null){
            System.out.println("There are no cars");
        }else ServicesCar.printCars(cars);
    }
    public void searchCarbyBrandandYear(Scanner reader){
        ValidatorData vd = new ValidatorData();
        System.out.println("Enter a brand");
        String brand = vd.checkCarBrand(reader.next());
        System.out.println("Enter a year");
        String year = vd.checkCarYear(reader.next());
        List<Car> cars =PersistenceCEOCR.searchCarsbyOptions("null",brand,year,3);
        if(cars== null){
            System.out.println("There are no cars");
        }else ServicesCar.printCars(cars);
    }
    public void searchCarbyColorandBrand(Scanner reader){
        ValidatorData vd = new ValidatorData();
        System.out.println("Enter a color");
        String color = vd.checkColorCar(reader.next());
        System.out.println("Enter a brand");
        String brand = vd.checkCarBrand(reader.next());
        List<Car> cars =PersistenceCEOCR.searchCarsbyOptions(color,brand,"null",4);
        if(cars== null){
            System.out.println("There are no cars");
        }else ServicesCar.printCars(cars);
    }

    public  void removeCar(Scanner reader){
        System.out.println("Enter a license");
        String license = reader.next();
        Car car ;
        car =PersistenceCEOCR.find(license,3);
        if(car== null){
            System.out.println("this car no exists");
        }else{
            System.out.println(car);
            PersistenceCEOCR.remove(car,car.getCarLicense(),3);
        }
    }

}
