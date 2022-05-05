package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.company.DataBase;
import com.company.Customer;

public class Main2 {
    static  int age;
    public static void main(String[] args)
    {
        metodo1();
    }

    public static  void metodo1(){
        Scanner scanner = new Scanner(System.in);
        String[] vars0 = new String[7];

        String[] vars2 = new String[] {"dni?", "name?", "surname?","age?", "phone?", "favorite color car?", "favorite brand car?"};


        for(int i = 0, y = 0; i < vars2.length ; i++, y++) {
            System.out.println(vars2[y]);
            if (vars2[y].equals("age?")){
                vars0[i] = scanner.nextLine();
                age = Integer.parseInt(vars0[i]);
            }else if(!"age?".equals(vars2[y])){
                vars0[i] = scanner.nextLine();
            }
        }


        //db.addCustomer(vars0[0]);
        System.out.println(vars0[0]);



    }


}

