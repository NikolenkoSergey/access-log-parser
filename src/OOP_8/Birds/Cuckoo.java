package OOP_8.Birds;

import java.util.Random;

public class Cuckoo extends Bird{

    @Override
    public void sing() {
        Random random = new Random();
        int i = random.nextInt(10) +1;
        for (int j = 0; j < i; j++) {
            System.out.println("ку-ку");
        }
    }
}
