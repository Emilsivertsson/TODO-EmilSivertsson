package org.CodeForPizza;

import java.util.Scanner;

public class Input {

    static Scanner scanner = new Scanner(System.in);


    /**
     * This method is used to get a Integer from the user
     * @param prompt to show the user
     * @return the string the user input
     */
    public int inputNumber(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Output.invalidInput());
            return inputNumber(prompt);
        }

    }

    /**
     * This method is used to get a string from the user
     * @param prompt to show the user
     * @return the string the user input
     */
    public String inputString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }


}
