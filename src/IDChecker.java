import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDChecker {

    public static void main(String[] args) {
        System.out.println(conditionChecker("10000000146"));
    }

    //verification conditions
    public static boolean checkLength(String idNumber){
        if (idNumber.length()==11){
            return true;
        }throw new IllegalStateException("Given ID should have 11 digits.");}
    public static boolean isAllDigits(String idNumber){
         if (idNumber.matches("\\d+")){
             return true;
         }throw new NumberFormatException("Given ID should be consists of only integers.");
    }
    public static boolean notStartsWithZero(String idNumber){
        if ((!idNumber.startsWith("0"))){
            return true;
        }throw new IllegalStateException("Given ID cannot start with 0(zero).");
    }
    public static boolean checkLastTwoDigit(String idNumber){
        String idealLastTwo = idealLastTwoDigit(idNumber);
        if (idNumber.substring(9,11).equals(idealLastTwo)){
            return true;
        }throw new IllegalStateException("Something went wrong with last 2 digits.");
    }


    //returns ideal last two digits of given id
    public static String idealLastTwoDigit(String idNumber){
        String firstNineDigit = idNumber.substring(0,9);
        int sumOdd = 0;
        int sumEven = 0;
        int tenthDigit;
        int lastDigit;
        String resultDigit = "";

        String[] idNoArray = new String[firstNineDigit.length()];
        for (int i=0; i<firstNineDigit.length(); i++){
            idNoArray[i] = Character.toString(firstNineDigit.charAt(i));
        }
        for (int element=0; element<firstNineDigit.length();element++){
            if (element%2==0){
                sumOdd += Integer.valueOf(idNoArray[element]);
            } else if (element%2==1) {
                sumEven += Integer.valueOf(idNoArray[element]);
            }
        }
        tenthDigit =(7*sumOdd -sumEven)%10;
        lastDigit = (sumEven +  sumOdd + tenthDigit)%10;
        resultDigit += tenthDigit;
        resultDigit += lastDigit;

        return resultDigit;
    }
    public static String conditionChecker(String idNumber){
        if (checkLength(idNumber)&&isAllDigits(idNumber)&&notStartsWithZero(idNumber)&&checkLastTwoDigit(idNumber)){
            return String.format("*--Given ID(%s) is valid.--*",idNumber);
        }return String.format("*--Given ID(%s) is invalid!--*",idNumber);
    }


}




