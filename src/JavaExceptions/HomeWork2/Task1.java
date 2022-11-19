package JavaExceptions.HomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static void main(String[] args) {

        System.out.println(enterNumber());
    }

    public static float enterNumber() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a float number please");

        String str;
        float floatNumber;

        try {

        str = reader.readLine();
        floatNumber = Float.parseFloat(str);

        } catch (NumberFormatException e1) {

            System.out.println("Error while parsing, please enter a correct float number");
            // e1.printStackTrace();
            return enterNumber();

        } catch (IOException e2) {

            System.out.println("What is it?");
            // e2.printStackTrace();
            return enterNumber();
        }

        return floatNumber;
    }
}
