package com.services;

import com.controller.DatabaseController;
import com.model.Car;

import java.util.List;
import java.util.Scanner;

public class ServicesCar {

    public static Car  selectCar(List<Car> carList2, Car car){
        ValidatorData vd = new ValidatorData();
        Scanner reader = new Scanner(System.in);
        int choiceCar;
        do {
            System.out.println("Enter a brand");
            String brand = vd.checkCarBrand(reader.next());
            System.out.println("Enter a color");
            String color = vd.checkColorCar(reader.next());
            System.out.println("1-Year\n" + "2-Not Year\n" + "3-Exit");
            choiceCar = reader.nextInt();
            if (choiceCar == 1) {
                System.out.println("Enter year");
                String year = vd.checkCarYear(reader.next());
                carList2= ServicesOrder.listCar(brand,color,year);
            }else if (choiceCar == 2) {
                carList2= ServicesOrder.listCar(brand,color);
            }else if (choiceCar == 3) {

            }
            if(carList2.isEmpty()) {
                System.out.println("there is not car to match these attributes");
                break;
            }
            car = selectCars(carList2, reader);
            break;
        } while (choiceCar != 3);
    return car;
    }

    public static Car selectCars(List<Car> carList2, Scanner reader){
        printCars(carList2);
        System.out.println("Select a car");
        int choiceCar = reader.nextInt();
        Car car = carList2.get(choiceCar);
        return car;
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
