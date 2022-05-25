package com;


import java.util.Scanner;
import com.model.*;
import com.view.ViewMenu;
public class Main {//Main
    public static void main(String[] args) {

        fakeEmployees();
        fakeCars();
        Scanner reader = new Scanner(System.in);
        ViewMenu.MainMenu(reader);

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
        Car car = new Car("BMW","4","White",0,"1257PSW","N",30000,"2022");
        Car car1 = new Car("MercedesBenz","4","Grey",150000,"9834WDF","Y",25000,"2010");
        Car car2 = new Car("Audi","2","Black",300000,"4564SCV","N",12500,"2011");
        Car car3 = new Car("Lexus","2","Silver",55000,"8988FFG","N",18500,"2017");
        Car car4 = new Car("Renault","4","Blue",0,"9432ZXY","Y",17000,"2016");
        Car car5 = new Car("Ford","2","Red",0,"6545JKH","N",18300,"2021");
        Car car6 = new Car("Opel","4","Beige",0,"8761PRB","Y",23500,"2022");
        Car car7 = new Car("MercedesBenz","4","Green",100000,"0127XLN","N",25000,"2013");
        Car car8 = new Car("BMW","4","WHITE",80000,"0618ZMS","N",16000,"2014");
        Car car9 = new Car("BMW","4","White",0,"5912VTJ","Y",40000,"2014");
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


}//Main