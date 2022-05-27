package com.controller;
import com.manager_persistences.PersistenceEmployee;
import com.manager_persistences.PersistenceCar;
import com.manager_persistences.PersistenceCustomer;
import com.manager_persistences.PersistenceOrder;
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
        System.out.println("-----------Data by Employee-------------");
        String employeeDni = EmployeeController.confirmIsLoginDni(reader);
        //----------------------------------------------------------
        if(!employeeDni.equals("incorrect dni")){
            carList2 = ServicesCar.selectCar(carList2);

            if(carList2 != null ){
                if(carList2.size() != 0){
                    car = ServicesCar.selectCars(carList2,reader);
                    System.out.println("-----------Data by Customer-------------");
                    String dni = Utilities.askInfo(reader, "Enter a dni");
                    Customer customer = PersistenceCustomer.findCustomer(dni);
                    if(customer!=null){
                        HashMap<Long,Integer> hasMapCard = ServicesCard.hashmapCardnumberStatus(customer);
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
                                Order order = new Order(String.valueOf(cardNumber), car, PersistenceEmployee.searchEmployee(employeeDni).getName(), Utilities.date(), idOrder, customer.getName());
                                System.out.println(order);
                                if(Utilities.actionVerification(reader,"make a purchase").equals("Y")){
                                    PersistenceOrder.orderPersistence(order);
                                    PersistenceCar.removeCar(car);
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
                    //----------------------------------------------------------

                    //----------------------------------------------------------

                }
            }
            if(carList2 == null){
                System.out.println("bye");
            }else System.out.println("bye end");
        }
    }

}
