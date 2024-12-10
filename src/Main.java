import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        while (true) {
            System.out.print("Укажите путь к файлу: ");
            String pach = new Scanner(System.in).nextLine();

            File file = new File(pach);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();

            if (!fileExists) {
                System.out.println("Файл не существует");
                continue;
            } else if (isDirectory) {
                System.out.println("Указанный путь является путём к папке");
                continue;
            }
            n++;
            System.out.println("Путь указан верно! \nЭто файл номер " + n);
        }
    }
}