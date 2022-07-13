package com.controller;
import com.manager_persistences.PersistenceCEOCR;
import com.model.*;
import com.services.ServicesCar;
import com.services.ServicesCard;
import com.utils.Utilities;

import java.util.*;
public class OrderController {

    static int choice;
    static  List<Car> carList2;
    public static void makeCarSale(Scanner reader){
        //---------------------------------------------------------
        System.out.println("-----------Data by Employee-------------");
        String employeeDni = EmployeeController.confirmIsLoginDni(reader);
        //----------------------------------------------------------
        if(!employeeDni.equals("incorrect dni")){
            carList2 = ServicesCar.selectCar(carList2);

            if(!(carList2 == null) ){
                if(carList2.size() != 0){
                    Car car = ServicesCar.selectCars(carList2,reader);
                    System.out.println("-----------Data by Customer-------------");
                    String dni = Utilities.askInfo(reader, "Enter a dni");
                    Customer customer = PersistenceCEOCR.find(dni,1);
                    if(customer!=null){
                        HashMap<Long,Integer> hasMapCard = ServicesCard.hashmapCardnumberStatus(customer);
                        do{
                            ServicesCard.showCards(customer);
                            System.out.println("Chose a Card");
                            int a = reader.nextInt();
                            //----------------------------------------------------------
                            Long cardNumber = customer.getCards().get(a).getNumberCard();
                            int status = 1;//hasMapCard.get(cardNumber);
                            //----------------------------------------------------------
                            if(status == 1){
                                String idOrder = employeeDni + car.getCarLicense();
                                OrderDealer o = new OrderDealer(idOrder,car,String.valueOf(cardNumber),Utilities.date(),employeeDni, customer.getName());
                                System.out.println(o);
                                if(Utilities.actionVerification(reader,"make a purchase").equals("Y")){
                                    PersistenceCEOCR.persistence(o);
                                    //o.setCar(car);
                                   // PersistenceCEOCR.SetOrderCar(o);
                                    PersistenceCEOCR.statusCar(car);
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
