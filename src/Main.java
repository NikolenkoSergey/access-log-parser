import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Введите первое число");
        int firstNumber = scanner.nextInt();
        System.out.println("Введите второе число");
        int secondNumber = scanner.nextInt();
        scanner.close();

        System.out.println("Сумма введенныех чисел: " + (firstNumber + secondNumber));
        System.out.println("Разность введенныех чисел: " + (firstNumber - secondNumber));
        System.out.println("Поризведение введенныех чисел: " + (firstNumber * secondNumber));
        System.out.println("Частное введенныех чисел: " + ((double)firstNumber / secondNumber));
    }
}