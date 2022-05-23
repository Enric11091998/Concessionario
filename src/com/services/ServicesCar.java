package com.services;

import com.controller.DatabaseController;
import com.model.Car;

import java.util.List;
import java.util.Scanner;

public class ServicesCar {

    public static void selectCar(List<Car> carList2, Car car, int w){
        ValidatorData vd = new ValidatorData();
        Scanner reader = new Scanner(System.in);
        int chociceCar;
        do {
            System.out.println("Enter a brand");
            String brand = vd.checkCarBrand(reader.next());
            System.out.println("Enter a color");
            String color = vd.checkColorCar(reader.next());
            System.out.println("1-Year\n" + "2-Not Year\n" + "3-Exit");
            chociceCar = reader.nextInt();
            if (chociceCar == 1) {
                System.out.println("Enter year");
                String year = vd.checkCarYear(reader.next());
                ServicesOrder.listCar(brand,color,year,carList2);
            }else if (chociceCar == 2) {
                ServicesOrder.listCar(brand,color,carList2);
            }if(carList2.isEmpty()) {
                System.out.println("there is not car to match these attributes");
                break;
            }
            selectCars(carList2,reader,car,  w);
            break;
        } while (chociceCar != 3);

    }

    public static void selectCars(List<Car> carList2, Scanner reader, Car car, int w){
        printCars(carList2);
        System.out.println("Select a car");
        int choicecar = reader.nextInt();
        car = carList2.get(choicecar);
         w = DatabaseController.searchCars(car.getCarLicense());
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
