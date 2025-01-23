import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        while (true) {
            System.out.print("Укажите путь к файлу: ");
            String path = new Scanner(System.in).nextLine();

            File file = new File(path);
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


            FileReader fileReader = null;
            try {
                fileReader = new FileReader(path);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line;
            int countLine = 0, maxLength = 0, minLength = Integer.MAX_VALUE;
            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                int length = line.length();
                // Созданный класс исключения
                if (length > 1024) throw new LineTooLongException("Длина строки превышает допустимое значение");

                // Самая длинная строка
                if (length > maxLength) {
                    maxLength = length;
                }
                // Самая короткая строка
                if (length < minLength) {
                    minLength = length;
                }
                // число строк в файле
                countLine++;
            }
            System.out.println("Число строк в файле: " + countLine);
            System.out.println("Длина самой длинной строки в файле: " + maxLength);
            System.out.println("Длина самой короткой строки в файле: " + minLength);

//   C:\Users\snikolenko\Desktop\Курс по Java\access.log
        }
    }
}