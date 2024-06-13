//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        String firstNum = numbers[0];
        if (numbers.length == 3 && (firstNum.contains("1") || firstNum.contains("2") || firstNum.contains("3") || firstNum.contains("4") || firstNum.contains("5") || firstNum.contains("6") || firstNum.contains("7") || firstNum.contains("8") || firstNum.contains("9") || firstNum.contains("0"))) {
            Arithmetic(numbers, numbers[1]);
        } else {
            if (numbers.length != 3) {
                throw new Exception();
            }

            RomanArithmetic(numbers, numbers[1]);
        }

    }

    public static String arabicToRoman(int number) {
        if (number > 0 && number <= 4000) {
            List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
            int i = 0;
            StringBuilder sb = new StringBuilder();

            while(number > 0 && i < romanNumerals.size()) {
                RomanNumeral currentSymbol = (RomanNumeral)romanNumerals.get(i);
                if (currentSymbol.getValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getValue();
                } else {
                    ++i;
                }
            }

            return sb.toString();
        } else {
            throw new IllegalArgumentException("" + number + " is not in range (0,4000]");
        }
    }

    public static void Arithmetic(String[] numbers, String sign) throws Exception {
        if (Arrays.asList(numbers).contains(sign)) {
            int result = Arrays.stream(numbers).filter((x) -> {
                return !x.equals(sign);
            }).mapToInt((x) -> {
                return Integer.parseInt(x);
            }).filter((x) -> {
                if (x >= 1 && x <= 10) {
                    return true;
                } else {
                    try {
                        throw new Exception("Числа должны быть от 1 до 10");
                    } catch (Exception var2) {
                        Exception e = var2;
                        throw new RuntimeException(e);
                    }
                }
            }).reduce((x, y) -> {
                switch (sign) {
                    case "+":{
                        return x + y;
                    }
                    case "-":{
                        return x - y;
                    }
                    case "*": {
                        return x * y;
                    }
                    case "/" : {
                        return x / y;
                    }
                    default: {
                        return x;
                    }
                }
            }).orElse(0);
            System.out.println("Результат = " + result);
        }

    }

    public static void RomanArithmetic(String[] numbers, String sign) throws Exception {
        if (Arrays.asList(numbers).contains(sign)) {
            int result = Arrays.stream(numbers).filter((x) -> {
                return !x.equals(sign);
            }).mapToInt((x) -> {
                return RomanNumeral.valueOf(x).getValue();
            }).filter((x) -> {
                if (x >= 1 && x <= 10) {
                    return true;
                } else {
                    try {
                        throw new Exception("Числа должны быть от 1 до 10");
                    } catch (Exception var2) {
                        Exception e = var2;
                        throw new RuntimeException(e);
                    }
                }
            }).reduce((x, y) -> {
                switch (sign) {
                    case "+":return x + y;
                    case "-":return x - y;
                    case "*": return x * y;
                    case "/": return x / y;
                    default : return x;
                }
            }).orElse(0);
            System.out.println("Результат = " + arabicToRoman(result));
        }

    }
}
