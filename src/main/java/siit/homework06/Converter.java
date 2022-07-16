package siit.homework06;

import java.util.Locale;

public class Converter {
    /**
     * In this method we use an if to check what is the symbol for the unit measure desired for the output. We use a switch
     * method to assign different conversion values to each unit. We use a for to check all the input array. When the loop finds a unit measure
     * we know that in the previous position in the array we need to have a value. We then parse that value to a double, we compute the appropriate
     * conversion and transform it back into a string.
     * We use every else if to get every possible output unit measure and make the appropriate conversions to each of them. If the output measure is not one
     * of the ones used in the if, we show a message in the console stating that the unit measure is not recognized.
     * @param outputUnit is the symbol of the unit measure you want the output to be in.
     * @param inputArray is the array obtained from the input equation after the regex split at every white space in the equation.
     */
    public void convertedArray(String outputUnit, String[] inputArray){
        if(outputUnit.equalsIgnoreCase("mm")){
            for (int i = 0; i < inputArray.length; i++) {

                switch (inputArray[i].toUpperCase(Locale.ROOT)) {
                    case "DM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 100);
                    case "CM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 10);
                    case "M" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 1000);
                    case "KM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 1_000_000);
                    default -> {
                    }
                }
            }
        }else if(outputUnit.equalsIgnoreCase("cm")){
            for (int i = 0; i < inputArray.length; i++) {

                switch (inputArray[i].toUpperCase(Locale.ROOT)) {
                    case "DM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 10);
                    case "MM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 10);
                    case "M" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 100);
                    case "KM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 100_000);
                    default -> {
                    }
                }
            }
        } else if (outputUnit.equalsIgnoreCase("dm")) {
            for (int i = 0; i < inputArray.length; i++) {

                switch (inputArray[i].toUpperCase(Locale.ROOT)) {
                    case "MM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 100);
                    case "CM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 10);
                    case "M" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 10);
                    case "KM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 10_000);
                    default -> {
                    }
                }
            }
        } else if (outputUnit.equalsIgnoreCase("m")) {
            for (int i = 0; i < inputArray.length; i++) {

                switch (inputArray[i].toUpperCase(Locale.ROOT)) {
                    case "DM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 10);
                    case "CM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 100);
                    case "MM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 1000);
                    case "KM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) * 1000);
                    default -> {
                    }
                }
            }
        } else if (outputUnit.equalsIgnoreCase("km")) {
            for (int i = 0; i < inputArray.length; i++) {

                switch (inputArray[i].toUpperCase(Locale.ROOT)) {
                    case "DM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 10_000);
                    case "CM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 100_000);
                    case "M" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 1000);
                    case "MM" -> inputArray[i - 1] = String.valueOf(Double.parseDouble(inputArray[i - 1]) / 1_000_000);
                    default -> {
                    }
                }
            }
        }else {
            System.out.println("Unit measures not supported. Please insert one of the following: MM, CM, DM, M or KM");
        }
    }
}
