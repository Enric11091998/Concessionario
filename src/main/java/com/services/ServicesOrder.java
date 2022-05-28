package com.services;

import com.manager_persistences.PersistenceCar;
import com.model.Car;
import com.model.DataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesOrder {

//    public static List<Car> listCar(String brand, String color, String year){
//        List<Car> carList2 = PersistenceCar.searchCardsbyColorBrandYear(brand,color,year);
//        return carList2;
//    }
    public static List<Car> listCar(String brand, String color){
        List<Car> carList2 = PersistenceCar.searchCardsbyColorBrand(brand,color);
        return carList2;
    }
}
