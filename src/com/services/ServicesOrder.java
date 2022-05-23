package com.services;

import com.model.Car;
import com.model.DataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesOrder {

    public static List<Car> listCar(String brand, String color, String year){
        List<Car> carList2 = DataBase.getCars().stream().filter(z -> z.getBrand().equalsIgnoreCase(brand) && z.getColor().equalsIgnoreCase(color) &&
                z.getYear().equals(year)).toList();
        return carList2;
    }
    public static List<Car> listCar(String brand, String color){
        List<Car> carList2 = DataBase.getCars().stream().filter(z -> z.getBrand().equalsIgnoreCase(brand) && z.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
        return carList2;
    }
}
