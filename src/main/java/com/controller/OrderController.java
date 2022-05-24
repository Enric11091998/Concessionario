package com.controller;
import com.model.*;
import com.services.ServicesCar;
import com.services.ServicesCard;
import com.utils.Utilities;
import java.util.*;
public class OrderController {

    static int choice, w;
    static Car car = new Car();
    static  List<Car> carList2;

    public static void makeCarSale(Scanner reader){
        OrderController o = new OrderController();
        DatabaseController db = new DatabaseController();
        CardController.getCardNumber();
        //---------------------------------------------------------
        System.out.println("Employee");
        String employeeDni = EmployeeController.confirmIsLoginDni(reader);
        //----------------------------------------------------------
        if(!employeeDni.equals("incorrect dni")){
            carList2 = ServicesCar.selectCar(carList2);

            if(carList2 != null ){
                if(carList2.size() != 0){
                    car = ServicesCar.selectCars(carList2,reader);
                    w = DatabaseController.searchCars(car.getCarLicense());
                    System.out.println("Customer");
                    String dni = Utilities.askInfo(reader, "Enter a dni");
                    int customerPosition = DatabaseController.searchCustomer(dni);
                    Customer customer = DataBase.getCustomers().get(customerPosition);
                    //----------------------------------------------------------
                    HashMap<Long,Integer> hasMapCard = ServicesCard.hashmapCardnumberStatus();
                    //----------------------------------------------------------
                    do{
                        ServicesCard.showCards(customer);
                        System.out.println("Chose a Card");
                        int a = reader.nextInt();
                        //----------------------------------------------------------
                        Long cardNumber = customer.getCards().get(a).getNumberCard();
                        int status = hasMapCard.get(cardNumber);
                        //----------------------------------------------------------
                        if(status == 1){
                            String idOrder = employeeDni + Utilities.date() + car.getCarLicense();
                            Order order = new Order(String.valueOf(cardNumber), car, db.getSearchEmployee(employeeDni).getName(), Utilities.date(), idOrder, customer.getName());
                            System.out.println(order);
                            if(Utilities.actionVerification(reader,"make a purchase").equals("Y")){
                                DataBase.getOrders().add(order);
                                DataBase.getCars().remove(w);
                                carList2.clear();
                                break;
                            }else break;
                        }if(status ==0){
                            System.out.println("This card does not have enough balance");
                            System.out.println("1-Select another card\n" + "2-Exit");
                            choice =reader.nextInt();
                        }
                    }while(choice != 2);
                }
            }
            if(carList2 == null){
                System.out.println("bye");
            }else System.out.println("bye end");
        }
    }

}
