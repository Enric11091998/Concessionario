package com.services;

import com.manager_persistences.PersistenceCEOCR;
import com.utils.Utilities;

import java.util.Scanner;

public class ServicesEmployee {

    public static void searchEmployee(Scanner reader){
        String dni = Utilities.askInfo(reader,"Enter a dni");
        boolean searchedEmployee = PersistenceCEOCR.exists(dni,2);
        if (!searchedEmployee) {
            System.out.println("No Employee was found with this dni");
        } else {
            System.out.println("Employee found " + searchedEmployee);
        }
    }
}
