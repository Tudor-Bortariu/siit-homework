package siit.homework06;

import java.util.*;
public class Calculator {

    /**
     * In this method we use the checkInput method to check if the given equation has the accepted format for the calculate method.
     * If the equation is accepted, we split the input by each white space and create also an array list with the same values as the array
     * obtained after the split. We use the convert method to change the values in the array accordingly to the measure unit desired for
     * the output. After that, we assign to the result variable the first number from the array. We use an if to make sure the array list
     * contains operands. We use a for pass through every element of the array and after each operand to, parse into double and add or subtract
     * the next element of the array from the result variable.
     * @param equation is the equation you need a result for.
     * @param outputUnitMeasure is the unit measure you want the output to be converted in.
     * @return returns a double value as the result of the equation.
     */
    public double calculate(String equation, String outputUnitMeasure) {

        CheckInputFormat checkInputFormat = new CheckInputFormat();

        if (checkInputFormat.checkInput(equation) && outputUnitMeasure.length() <= 2) {

            String[] inputArray = equation.split(" ");
            List<String> inputList = Arrays.asList(inputArray);

            Converter converter = new Converter();
            converter.convertedArray(outputUnitMeasure, inputArray);

            double result = Double.parseDouble(inputArray[0]);
            if (inputList.contains("+") || inputList.contains("-")) {
                for (int i = 0; i < inputArray.length; i++) {
                    if (inputArray[i].equalsIgnoreCase("+")){
                        result += Double.parseDouble(inputArray[i + 1]);
                    }else if(inputArray[i].equalsIgnoreCase("-")){
                        result -= Double.parseDouble(inputArray[i + 1]);
                    }
                }
            }
            System.out.println("The result of the equation is " + result + " " + outputUnitMeasure);
            return result;
        } else if(outputUnitMeasure.length() > 2){
            throw new RuntimeException("Please insert just the symbol of the measure unit: MM, CM, DM, M or KM");
        }else{
            throw new RuntimeException("The accepted format for the equation is: X um + Y um . Please make sure you have white spaces between each element of the equation.");
        }
    }
}