/**
 *
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "1- natal aspects" +
                "2- synastry" +
                "3- composite");
        int option = sc.nextInt();
        options op = new options();

        switch (option){
            case 1: op.get_natal_aspects(); break;
            case 2: op.synastry(); break;
            case 3: op.composite(); break;
            default:
                System.out.println("not an option");
        }

    }




}

