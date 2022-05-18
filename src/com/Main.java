package com;

import java.util.ArrayList;
import java.util.Scanner;

import com.model.*;
import com.controller.DatabaseController;
import com.view.ViewMenu;

public class Main {//Main
    public static void main(String[] args) {
        fakeCustomers();
        fakeEmployees();
        fakeCars();
        Scanner reader = new Scanner(System.in);
        ViewMenu.Mainmenu(reader);

    }


    public static void fakeEmployees(){
        Employee employee1 = new Employee("12345678Q","Federico","Garcia",23,"Employee","1","38","Student1!");
        Employee employee2 = new Employee("12345678A","Alicia","Clare",24,"Manager","2","39","Student2!");
        Employee employee3 = new Employee("12345678Z","Jordi","Draconius",18,"Manager","3","39","Student3!");
        Employee employee4 = new Employee("12345678X","Brian","O'Connor",25,"Employee","4","40","Student4!");
        Employee employee5 = new Employee("12345678Y","Lionel","Stuart",19,"Employee","5","38","Student5!");
        DataBase.getEmployees().add(employee1);
        DataBase.getEmployees().add(employee2);
        DataBase.getEmployees().add(employee3);
        DataBase.getEmployees().add(employee4);
        DataBase.getEmployees().add(employee5);
    }

    public static void fakeCars(){
        Car car = new Car("BMW","4","White",0,"1257PSW","N",30000);
        Car car1 = new Car("MercedesBenz","4","Grey",150000,"9834WDF","Y",25000);
        Car car2 = new Car("Audi","2","Black",300000,"4564SCV","N",12500);
        Car car3 = new Car("Lexus","2","Silver",55000,"8988FFG","N",18500);
        Car car4 = new Car("Renault","4","Blue",0,"9432ZXY","Y",17000);
        Car car5 = new Car("Ford","2","Red",0,"6545JKH","N",18300);
        Car car6 = new Car("Opel","4","Beige",0,"8761PRB","Y",23500);
        Car car7 = new Car("MercedesBenz","4","Green",100000,"0127XLN","N",25000);
        Car car8 = new Car("Nissan","4","Red",80000,"0618ZMS","N",16000);
        Car car9 = new Car("Lexus","4","White",0,"5912VTJ","Y",40000);
        DataBase.getCars().add(car);
        DataBase.getCars().add(car1);
        DataBase.getCars().add(car2);
        DataBase.getCars().add(car3);
        DataBase.getCars().add(car4);
        DataBase.getCars().add(car5);
        DataBase.getCars().add(car6);
        DataBase.getCars().add(car7);
        DataBase.getCars().add(car8);
        DataBase.getCars().add(car9);
    }
    public static void fakeCustomers(){
        ArrayList<Card> cards1 = new ArrayList<>(),  cards2 = new ArrayList<>(), cards3 = new ArrayList<>();
        cards1.add(new Card(5555748587548754L,"052022","visa","693"));
        cards1.add(new Card(5588888587548754L,"092022","mastercard","451"));
        cards2.add(new Card(4512748587548754L,"052026","mastercard","745"));
        cards2.add(new Card(4566666666648754L,"052027","visa","920"));
        cards3.add(new Card(5563748587548754L,"082024","visa","693"));
        Customer c1 = new Customer("12345678Q","JOSE","PEREZ","23","626745258","BLUE","FORD",cards1);
        Customer c2 = new Customer("12345678S","DANIEL","PAEZ","22","696245258","RED","LEXUS",cards2);
        Customer c3 = new Customer("12345678E","CARLOS","CASTILLO","20","698541258","GREEN","TOYOTA",cards3);
        Customer c4 = new Customer("12345678L","MIGUEL","MENDOZA","26","620963258","YELLOW","FORD");
        Customer c5 = new Customer("12345678V","JOSE","DIAZ","24","695145258","BLUE","BMW");

        Customer[] objects = new Customer[]{c1,c2,c3,c4,c5};
        for(int i = 0; i < 5; i++){
            DatabaseController.addCustomerWithouCard(objects[i]);
        }

    }

}//Main