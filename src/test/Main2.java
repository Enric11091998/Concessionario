package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.company.Card;
import com.company.DataBase;
import com.company.Customer;

public class Main2 {
    static  int age, securityCode;
    static  long numberCard;

    public static void main(String[] args)
    {


    }

    public static  void registerCustomer(){
        Scanner scanner = new Scanner(System.in);
        String[] vars0 = new String[7];
        String[] vars1 = new String[4];
        DataBase db = new DataBase();
        Customer customer = new Customer();
        Card card = new Card();

        String[] vars2 = new String[] {"dni?", "name?", "surname?","age?", "phone?", "favorite color car?", "favorite brand car?"};

        String[] chainWhithoutCard = new String[] {"dni?", "name?", "surname?","age?", "phone?", "favorite color car?", "favorite brand car?"};
        String[] chainCard = new String[] {"numberCard?","expiration?","type?","securityCode?"};

        for(int i = 0, y = 0; i < chainWhithoutCard.length ; i++, y++) {
            System.out.println(chainWhithoutCard[y]);
            if (chainWhithoutCard[y].equals("age?")){
                vars0[i] = scanner.nextLine();
                age = Integer.parseInt(vars0[i]);
            }else if(!"age?".equals(chainWhithoutCard[y])){
                vars0[i] = scanner.nextLine();
            }
            if (i>5){
                System.out.println("Card(Y or N)?");
                String input = scanner.nextLine();
                if(input.equals("Y")){
                    for(int x= 0, z= 0; x < chainCard.length;  x++, z++){
                        System.out.println(chainCard[z]);
                        if(chainCard[z].equals("numberCard?")){
                            vars1[x] = scanner.nextLine();
                            numberCard = Long.parseLong(vars1[x]);
                        }
                        else if (chainCard[z].equals("securityCode?")){
                            vars1[x] = scanner.nextLine();
                            securityCode = Integer.parseInt(vars1[x]);
                        }
                        else if (!"numberCard?".equals(chainCard[z]) && !"securityCode?".equals(chainCard[z])){
                            vars1[x] = scanner.nextLine();
                        }
                        if (x>2){
                            card =new Card(numberCard,vars1[1],vars1[2],securityCode);
                            db.addCustomersCard(vars0[0],vars0[1],vars0[2],age,vars0[4],vars0[5],vars0[6],card);
                            System.out.println(db.getCustomers().toString());
                        }
                    }
                }
                if(input.equals("N")){
                    db.addCustomerWithouCard(vars0[0],vars0[1],vars0[2],age,vars0[4],vars0[5],vars0[6]);
                    System.out.println(db.getCustomers().toString());
                }
            }
        }
    }
}

