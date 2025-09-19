package example;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        int sum = 0;
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            sum += value;
        }

        System.out.println("The sum of the input is " + sum);

        scanner.close();
    }
}
