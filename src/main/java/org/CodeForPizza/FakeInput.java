package org.CodeForPizza;

public class FakeInput {

    public int inputNumber(int value) {
        try {
            return value;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please input a number");
        }
    }


    public String inputString(String prompt) {
        return prompt;
    }


}
