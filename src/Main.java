import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    static String input;                                            // ввод со сканера
    static boolean firstRoman, secondRoman, firstArab, secondArab;  // проверка на принадлежность к арабским/римским числам
    static int rom1, rom2, num1, num2;                              // рабочие числа
    static int result;                                              // результат операции
    static String calcResultAsString;                               // строка результата калькулятора
        public static void main(String[] args) throws Exception {
            System.out.println("Это калькулятор арабских и римских чисел. Поддерживается ввод только двух чисел. \n" +
                    "Оба числа должны быть СТРОГО от 1 до 10 в одном формате (только арабские или только римские). \n" +
                    "Список доступных операций: (+)(-)(*)(/) \n" + "\n" + "Введите выражение (через ПРОБЕЛ):");
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();                                  // строка от пользователя
            String resultStr = calc(input);                         // строку input отправляем в метод Calc,  ответ придет в resultString
            System.out.println("Ответ: " + resultStr);              // это полученный результат для отображения
        }
        public static String calc(String input) throws Exception {
            String inputFinal = input.toUpperCase();                // исключим вероятность ввода маленьких римских цифр
            String[] operands = inputFinal.split(" ");
            String firstValue = operands[0];                        // первое число
            String operation = operands[1];                         // знак
            String secondValue = operands[2];                       // второе число
                if (firstValue.equals("I") || firstValue.equals("II") || firstValue.equals("III") || firstValue.equals("IV") ||
                        firstValue.equals("V") || firstValue.equals("VI") || firstValue.equals("VII") || firstValue.equals("VIII") ||
                        firstValue.equals("IX") || firstValue.equals("X")) {
                    firstRoman = true;                              // первое число - римское
                } else {
                    firstRoman = false;                             // первое число - не римское
                }
                if (secondValue.equals("I") || secondValue.equals("II") || secondValue.equals("III") || secondValue.equals("IV") ||
                        secondValue.equals("V") || secondValue.equals("VI") || secondValue.equals("VII") || secondValue.equals("VIII") ||
                        secondValue.equals("IX") || secondValue.equals("XX")) {
                    secondRoman = true;                             // второе число - римское
                } else {
                    secondRoman = false;                            // второе число - не римское
                }
                if (firstValue.equals("1") || firstValue.equals("2") || firstValue.equals("3") || firstValue.equals("4") ||
                            firstValue.equals("5") || firstValue.equals("6") || firstValue.equals("7") || firstValue.equals("8") ||
                            firstValue.equals("9") || firstValue.equals("10")) {
                    firstArab = true;                                // первое число - арабское
                } else {
                    firstArab = false;                               // первое число - не арабское
                }
                if (secondValue.equals("1") || secondValue.equals("2") || secondValue.equals("3") || secondValue.equals("4") ||
                            secondValue.equals("5") || secondValue.equals("6") || secondValue.equals("7") || secondValue.equals("8") ||
                            secondValue.equals("9") || secondValue.equals("10")) {
                    secondArab = true;                               // второе число - арабское
                } else {
                    secondArab = false;                              // второе число - не арабское
                }
                if (firstRoman!=secondRoman && firstArab!=secondArab){
                    throw new IllegalArgumentException("Ошибка! Введите числа из одинаковой системы счисления (ТОЛЬКО арабские ИЛИ ТОЛЬКО римские)");
                }

            HashMap<String, Integer> map = new HashMap<>();          // каждому значению римского числа присвоим его арабское соответствие
            map.put("I", 1); map.put("II", 2); map.put("III", 3); map.put("IV", 4); map.put("V", 5); map.put("VI", 6); map.put("VII", 7); map.put("VIII", 8); map.put("IX", 9); map.put("X", 10);
            map.put("XI", 11); map.put("XII", 12); map.put("XIII", 13); map.put("XIV", 14); map.put("XV", 15); map.put("XVI", 16); map.put("XVII", 17); map.put("XVIII", 18); map.put("XIX", 19); map.put("XX", 20);
            map.put("XXI", 21); map.put("XXII", 22); map.put("XXIII", 23); map.put("XXIV", 24); map.put("XXV", 25); map.put("XXVI", 26); map.put("XXVII", 27); map.put("XXVIII", 28); map.put("XXIX", 29); map.put("XXX", 30);
            map.put("XXXI", 31); map.put("XXXII", 32); map.put("XXXIII", 33); map.put("XXXIV", 34); map.put("XXXV", 35); map.put("XXXVI", 36); map.put("XXXVII", 37); map.put("XXXVIII", 38); map.put("XXXIX", 39); map.put("XL", 40);
            map.put("XLI", 41); map.put("XLII", 42); map.put("XLIII", 43); map.put("XLIV", 44); map.put("XLV", 45); map.put("XLVI", 46); map.put("XLVII", 47); map.put("XLVIII", 48); map.put("XLIX", 49); map.put("L", 50);
            map.put("LI", 51); map.put("LII", 52); map.put("LIII", 53); map.put("LIV", 54); map.put("LV", 55); map.put("LVI", 56); map.put("LVII", 57); map.put("LVIII", 58); map.put("LIX", 59); map.put("LX", 60);
            map.put("LXI", 61); map.put("LXII", 62); map.put("LXIII", 63); map.put("LXIV", 64); map.put("LXV", 65); map.put("LXVI", 66); map.put("LXVII", 67); map.put("LXVIII", 68); map.put("LXIX", 69); map.put("LXX", 70);
            map.put("LXXI", 71); map.put("LXXII", 72); map.put("LXXIII", 73); map.put("LXXIV", 74); map.put("LXXV", 75); map.put("LXXVI", 76); map.put("LXXVII", 77); map.put("LXXVIII", 78); map.put("LXXIX", 79); map.put("LXXX", 80);
            map.put("LXXXI", 81); map.put("LXXXII", 82); map.put("LXXXIII", 83); map.put("LXXXIV", 84); map.put("LXXXV", 85); map.put("LXXXVI", 86); map.put("LXXXVII", 87); map.put("LXXXVIII", 88); map.put("LXXXIX", 89); map.put("XC", 90);
            map.put("XCI", 91); map.put("XCII", 92); map.put("XCIII", 93); map.put("XCIV", 94); map.put("XCV", 95); map.put("XCVI", 96); map.put("XCVII", 97); map.put("XCVIII", 98); map.put("XCIX", 99); map.put("C", 100);

            if (firstRoman == true && secondRoman == true ){
                rom1 = map.get(firstValue);                          // присвоим значение из мапы для первого римского
                rom2 = map.get(secondValue);                         // присвоим значение из мапы для второго римского
                num1 = rom1;                                         // первое римское теперь то же, что и арабское
                num2 = rom2;                                         // второе римское теперь то же, что и арабское
            }
            if (firstArab == true && secondArab == true) {
                num1 = Integer.parseInt(firstValue);                 // если арабские, то переводим из string в инт
                num2 = Integer.parseInt(secondValue);                // если арабские, то переводим из string в инт
            }
                if (num1>10||num1<1||num2>10||num2<1) {
                    throw new IllegalArgumentException("Ошибка! Убедитесь, что вводимые числа БОЛЬШЕ нуля и НЕ БОЛЬШЕ десяти");
                }
                switch (operation) {
                    case ("+") :
                        result = num1 + num2;
                        break;
                    case ("-") :
                        result = num1 - num2;
                        break;
                    case ("*") :
                        result = num1 * num2;
                        break;
                    case ("/") :
                        result = num1 / num2;
                        break;
                    default:
                        throw new IllegalArgumentException("Ошибка! Допустимые знаки действий: (+)(-)(*)(/)");
                }
                calcResultAsString=String.valueOf(result);
                    if (firstRoman==true) {
                        if (result<=0) {
                            throw new IllegalArgumentException("Невозможно совершить действие. Римские числа не могут быть меньше 1");
                        }
                        for (Entry<String, Integer> entry : map.entrySet()) {
                            if (entry.getValue() == result) {
                                calcResultAsString = entry.getKey();
                                break;
                            }
                        }
                    }
            return calcResultAsString;
        }
}