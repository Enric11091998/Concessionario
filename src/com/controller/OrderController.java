package com.controller;

import com.model.Customer;
import com.model.Car;
import com.model.DataBase;
import com.model.Order;
import com.utils.Utilities;
import com.services.ValidatorData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderController {
    static int choice;


    public static void makeCarSale(Scanner reader) {

        //Employee need to identify itself (ask for a dni and compare with the login and return the dni) Enric "done"
        DatabaseController db = new DatabaseController();
        Car car;
        ValidatorData vd = new ValidatorData();
        List<Car> carList = new ArrayList<>();
        System.out.println("Employee");
        String employeeDni = EmployeeController.confirmIsLoginDni(reader);
        if (!employeeDni.equals("incorrect dni")) {
            //Search Cars by Brand,Color and year and select Biaggio
            for (int i = 0; i < DataBase.getCars().size(); i++) {
                car = DataBase.getCars().get(i);
                carList.add(car);
            }
            do {
                System.out.println("Enter a brand");
                String brand = vd.checkCarBrand(reader.next());
                System.out.println("Enter a color");
                String color = vd.checkColorCar(reader.next());
                System.out.println("1-Year\n" + "2-Not Year\n" + "3-Exit");
                choice = reader.nextInt();
                if (choice == 1) {
                    System.out.println("Enter year");
                    String year = vd.checkCarYear(reader.next());
                    List<Car> carList2 = carList.stream().filter(z -> z.getBrand().equalsIgnoreCase(brand) && z.getColor().equalsIgnoreCase(color) &&
                                    z.getYear().equals(year))
                            .collect(Collectors.toList());
                    System.out.println(carList2);


                } else if (choice == 2) {
                    List<Car> carList2 = carList.stream().filter(z -> z.getBrand().equalsIgnoreCase(brand) && z.getColor().equalsIgnoreCase(color))
                            .collect(Collectors.toList());
                    for (int x = 0; x < carList2.size(); x++) {
                        System.out.println(x + "- " + carList2.get(x));
                    }
                    System.out.println("Select a car");
                    int choicecar = reader.nextInt();
                    ;
                    car = carList2.get(choicecar);
                    System.out.println(car);

                }
            } while (choice != 3);
            //show customer by dni and select one of your cards Enric
            System.out.println("Customer");
            String dni = Utilities.askInfo(reader, "Enter a dni");
            int customerPosition = DatabaseController.searchCustomer(dni);
            Customer customer = DataBase.getCustomers().get(customerPosition);
            System.out.println(customer.getCards().toString());
            String cardNumber = Utilities.askInfo(reader, "Enter a Card number");

            //check card balance from an external Data base(boolean) Biaggio
            //get date Enric
            String date = String.valueOf(LocalDate.now());
            date = date.replace("-", "");
            //generate a unique idOrder by date, dni employee and car licence Enric/Biaggio
            //String idOrder = employeeDni + date + car.getCarLicense();
            //Confirm or cancel the order
            //if you confirm, delete car, save order in Data Base.
            //Order order = new Order(cardNumber, car, db.getSearchEmployee(employeeDni).getName(), date, idOrder, customer.getName());
        }
    }
}
