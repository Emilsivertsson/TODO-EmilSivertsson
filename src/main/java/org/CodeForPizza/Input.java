package org.CodeForPizza;

import java.util.Scanner;

/**
 * This class is used to get input from the user
 * The methods takes a prompt as a parameter, and returns the input from the user.
 * The methods also checks if the input is valid.
 * If the input is not valid, the method will call itself again.
 */
public class Input implements InputInterface {

    static Scanner scanner = new Scanner(System.in);

    @Override
    public int inputNumber(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Output.invalidInput());
            return inputNumber(prompt);
        }
    }

    @Override
    public String inputString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
