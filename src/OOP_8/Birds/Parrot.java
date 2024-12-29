package OOP_8.Birds;

import java.util.Random;
import java.util.Scanner;

public class Parrot extends Bird{
    @Override
    public void sing() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Что повторить попугаю:");
        String sing = scanner.nextLine();
        Random random = new Random();
        System.out.println(sing.substring(0, random.nextInt(sing.length())+1));
    }
}
