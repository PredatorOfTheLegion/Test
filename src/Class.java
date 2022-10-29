import java.util.Scanner;

public class Class {
    public static void main(String[] arg) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите выражение");
        String importC = console.nextLine();
        String finaly = Calc.calc(importC);
        System.out.println(finaly);
    }

}
class Calc{
    static String SwitchLatToRoman ( int numLat){// преобразование латинского символа в римский
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numLat];
        return s;
    }

    static String SwitchRomanToLat(String roman){// преобразование римского символа в латинский
        if (roman.equals("I")) {
            return "1";
        } else if (roman.equals("II")) {
            return "2";
        } else if (roman.equals("III")) {
            return "3";
        } else if (roman.equals("IV")) {
            return "4";
        } else if (roman.equals("V")) {
            return "5";
        } else if (roman.equals("VI")) {
            return "6";
        } else if (roman.equals("VII")) {
            return "7";
        } else if (roman.equals("VIII")) {
            return "8";
        } else if (roman.equals("IX")) {
            return "9";
        } else if (roman.equals("X")) {
            return "10";
        }
        return roman;
    }

    static String calc(String importC) {
        char typeSimbol1 = 'n';
        char typeSimbol2 = 'n';
        char typeOperand = '+';
        String simbol1 = "";
        String simbol2 = "";
        int resultInt = 0;
        String result = "Равно = ";
        int numberOperator = 0;
        for (int index=0; index<importC.length(); index++){
            if (importC.charAt(index) != '+' && importC.charAt(index) != '-' && importC.charAt(index) != ' ' && importC.charAt(index) != '/' && importC.charAt(index) != '*'){
                if(numberOperator==0){
                    simbol1 = simbol1 + importC.charAt(index);
                }
                else if (numberOperator ==1){
                    simbol2 = simbol2 + importC.charAt(index);
                }
                else{
                    System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    System.exit(0);
                }
            }
            else if(importC.charAt(index) != ' '){
                numberOperator++;
                typeOperand = importC.charAt(index);
            }
        }
        if (simbol2 == "" || simbol1 == ""){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }
        //Проверка типа символа 1
        if (Character.isDigit(simbol1.charAt(0))){
            typeSimbol1='l';
        }
        else if (simbol1 != "")typeSimbol1='g';

        // проверка типа символа 2
        if (Character.isDigit(simbol2.charAt(0))){
            typeSimbol2='l';
        }
        else if (simbol2 != "")  typeSimbol2='g';

            //Счет
        if (typeSimbol2 == typeSimbol1){
            if (typeSimbol1 == 'l'){
                if (typeOperand =='+'){
                resultInt= Integer.parseInt(simbol1) + Integer.parseInt(simbol2);
                result = "" + resultInt;
                }
                else if (typeOperand =='-'){
                    resultInt= Integer.parseInt(simbol1) - Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
                else if (typeOperand =='*'){
                    resultInt= Integer.parseInt(simbol1) * Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
                else if (typeOperand =='/'){
                    resultInt= Integer.parseInt(simbol1) / Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
            }
            if (typeSimbol1 =='g'){
                simbol1 = Calc.SwitchRomanToLat(simbol1);
                simbol2 = Calc.SwitchRomanToLat(simbol2);
                if (typeOperand =='+'){
                    resultInt= Integer.parseInt(simbol1) + Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
                else if (typeOperand =='-'){
                    resultInt= Integer.parseInt(simbol1) - Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
                else if (typeOperand =='*'){
                    resultInt= Integer.parseInt(simbol1) * Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }
                else if (typeOperand =='/'){
                    resultInt= Integer.parseInt(simbol1) / Integer.parseInt(simbol2);
                    result = "" + resultInt;
                }

                if (resultInt<=0){
                    System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    System.exit(0);
                }
                else{
                    result = Calc.SwitchLatToRoman(resultInt);
                }
            }
        }

        else {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            System.exit(0);
        }

        return result;
    }
}