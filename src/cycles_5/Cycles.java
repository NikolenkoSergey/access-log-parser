package cycles_5;

public class Cycles {
    public static void guessGame() {
        int randomNum = 3;
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x =0, y=0;
        while (x!=randomNum) {
            x = sc.nextInt();
            y++;
            if (x == randomNum) {
                System.out.println("Yes, it`s " + randomNum);
                System.out.println("Использовано попыток: " + y);
            } else {
                System.out.println("No, try again");
            }
        }
    }
    public static void rightTriangle(int x){
        for (int i = 1; i <= x; i++) {
            String p = " ".repeat(x-i);
            String s = "*".repeat(i);
            System.out.println(p+s);
        }
    }

    public static void leftTriangle(int x){
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void square(int x){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static boolean equalNum(int x){
        int y = x%10;
        for (; x > 0; x=x/10) {
            if(y!=x%10) return false;
            y = x%10;
        }
        return true;
    }

    public static int numLen(long x) {
        int y = 0;
        do {
            x = x / 10;
            y++;
        } while (x > 0);
        return y;
    }

    public static int pow(int x, int y) {
        int q = 1;
        for (int i = 0; i < y; i++) {
            q = q * x;
        }
        return q;
    }

    public static String chet(int x) {
        String str = "";
        for (int i = 0; i <= x; i += 2) {
            str += i + " ";
        }
        return str;
    }

    public static String reverseListNums(int x) {
        String str = "";
        for (int i = x; i >= 0; i--) {
            str += i + " ";
        }
        return str;
    }

    public static String listNums(int x) {
        String str = "";
        for (int i = 0; i <= x; i++) {
            str += i + " ";
        }
        return str;
    }
}
