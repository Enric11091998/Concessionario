package com.controller;

import com.model.*;
import com.services.ValidatorData;
import com.utils.Utilities;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderController {
    static  List<Car> carList = new ArrayList<>();
    static int choice;
    static Random random = new Random();
    static Car car = new Car();

    public static void makeCarSale(Scanner reader){
        OrderController o = new OrderController();
        DatabaseController db = new DatabaseController();
        CardController.getCardNumber();
        o.addCarslist();
        //---------------------------------------------------------
        System.out.println("Employee");
        String employeeDni = EmployeeController.confirmIsLoginDni(reader);
        //----------------------------------------------------------
        if(!employeeDni.equals("incorrect dni")){
            o.selectCar();
            if(!car.equals(null)){
                System.out.println("Customer");
                String dni = Utilities.askInfo(reader, "Enter a dni");
                int customerPosition = DatabaseController.searchCustomer(dni);
                Customer customer = DataBase.getCustomers().get(customerPosition);
                //----------------------------------------------------------
                o.hashmapCardnumberStatus();
                //----------------------------------------------------------
                o.showCards(customer);
                System.out.println("Chose a Card");
                int a = reader.nextInt();
                    //----------------------------------------------------------
                Long cardNumber = customer.getCards().get(a).getNumberCard();
                int status = o.hashmapCardnumberStatus().get(cardNumber);
                //----------------------------------------------------------
                if(status == 1){
                        String date = String.valueOf(LocalDate.now());
                        date = date.replace("-", "");
                        String idOrder = employeeDni + date + car.getCarLicense();
                        Order order = new Order(String.valueOf(cardNumber), car, db.getSearchEmployee(employeeDni).getName(), date, idOrder, customer.getName());
                        System.out.println(order);
                        if(Utilities.actionVerification(reader,"make a purchase").equals("Y")){
                            DataBase.getOrders().add(order);
                            DataBase.getCars().remove(car);
                        }
                    }
            }else System.out.println("This car no exists in stock");
        }
    }

    public void addCarslist(){
        for (int i = 0; i < DataBase.getCars().size(); i++) {
            car = DataBase.getCars().get(i);
            carList.add(car);
        }
    }

    public void selectCar(){
        ValidatorData vd = new ValidatorData();
        Scanner reader = new Scanner(System.in);
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
                for (int x = 0; x < carList2.size(); x++) {
                    System.out.println(x + "- " + carList2.get(x));
                }
                System.out.println("Select a car");
                int choicecar = reader.nextInt();
                car = carList2.get(choicecar);
                System.out.println(car)
                ;
                break;


            } else if (choice == 2) {
                List<Car> carList2 = carList.stream().filter(z -> z.getBrand().equalsIgnoreCase(brand) && z.getColor().equalsIgnoreCase(color))
                        .collect(Collectors.toList());
                for (int x = 0; x < carList2.size(); x++) {
                    System.out.println(x + "- " + carList2.get(x));
                }
                CardController.getCardNumber();
                System.out.println("Select a car");
                int choicecar = reader.nextInt();
                car = carList2.get(choicecar);
                System.out.println(car);
                break;

            }
        } while (choice != 3);

    }

    public void showCards(Customer customer){
        for(int i = 0; i < customer.getCards().size(); i++ ){
            System.out.println(i +"- "+ customer.getCards().get(i).getNumberCard());
        }
    }

    public HashMap<Long,Integer> hashmapCardnumberStatus(){
        HashMap<Long,Integer> cardsMap = new HashMap<>();
        for(int i =0 ; i < DataBase.getCards().size(); i++){
            Long key= DataBase.getCards().get(i);
            int value = random.nextInt(2);
            cardsMap.put(key,value);
        }
        return cardsMap;
    }

}
