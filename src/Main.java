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
                fileReader = new FileReader("C:\\Users\\snikolenko\\Desktop\\Курс по Java\\access.log");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            BufferedReader reader =
                    new BufferedReader(fileReader);
            String line;
            int lineCount = 0, maxLength = 0, minLength = Integer.MAX_VALUE, yandexBotCount = 0, googleBotCount = 0;
            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                int length = line.length();
                // Созданный класс исключения
                if (length > 1024) throw new LineTooLongException("Длина строки превышает допустимое значение");


                //Разбивка строки на фрагментны
                String[] arrayOfLines = line.split(" ");
                String ipAddress = arrayOfLines[0];
                String otherProperty = arrayOfLines[1] + ", " + arrayOfLines[2];
                String dataTime = arrayOfLines[3] + " " + arrayOfLines[4];
                String method = arrayOfLines[5] + " " + arrayOfLines[6];
                String httpResponse = arrayOfLines[7] + " " + arrayOfLines[8];
                String size = arrayOfLines[9];
                String link = arrayOfLines[10];
                String userAgent = "";
                for (int i = 11; i < arrayOfLines.length; i++) {
                    userAgent = userAgent + " " + arrayOfLines[i];
                }

                // число строк в файле
                lineCount++;


                if (searchBotInLine(userAgent) != null) {
                    if (searchBotInLine(userAgent).equals("YandexBot")) yandexBotCount++;
                    if (searchBotInLine(userAgent).equals("Googlebot")) googleBotCount++;
                }

            }

            // Находим долю ботов yandexBot и googleBot от общего числа запросов
            double yandexBotPercentage = ((double) yandexBotCount / lineCount) * 100;
            double googleBotCountPercentage = ((double) googleBotCount / lineCount) * 100;

            System.out.println("Число строк в файле: " + lineCount);
            System.out.println("Googlebot: " + yandexBotPercentage);
            System.out.println("Googlebot: " + googleBotCountPercentage);

        }
    }


//   C:\Users\snikolenko\Desktop\Курс по Java\access.log


//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader("C:\\Users\\snikolenko\\Desktop\\Курс по Java\\access.log");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        BufferedReader reader =
//                new BufferedReader(fileReader);
//        String line;
//        int lineCount = 0, maxLength = 0, minLength = Integer.MAX_VALUE, yandexBotCount = 0, googleBotCount = 0;
//        while (true) {
//            try {
//                if ((line = reader.readLine()) == null) break;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            int length = line.length();
//            // Созданный класс исключения
//            if (length > 1024) throw new LineTooLongException("Длина строки превышает допустимое значение");
//
//            //Разбивка строки на фрагметны
//            String[] arrayOfLines = line.split(" ");
//            String ipAddress = arrayOfLines[0];
//            String otherProperty = arrayOfLines[1] + ", " + arrayOfLines[2];
//            String dataTime = arrayOfLines[3] + " " + arrayOfLines[4];
//            String method = arrayOfLines[5] + " " + arrayOfLines[6];
//            String httpResponse = arrayOfLines[7] + " " + arrayOfLines[8];
//            String size = arrayOfLines[9];
//            String link = arrayOfLines[10];
//            String userAgent = "";
//            for (int i = 11; i < arrayOfLines.length; i++) {
//                userAgent = userAgent + " " + arrayOfLines[i];
//            }
//
//            // число строк в файле
//            lineCount++;
//
//
//            if (searchBotInLine(userAgent) != null) {
//                if (searchBotInLine(userAgent).equals("YandexBot")) yandexBotCount++;
//                if (searchBotInLine(userAgent).equals("Googlebot")) googleBotCount++;
//            }
//
//        }
//
//        // Находим долю ботов yandexBot и googleBot от общего числа запросов
//        double yandexBotPercentage = ((double) yandexBotCount / lineCount) * 100;
//        double googleBotCountPercentage = ((double) googleBotCount / lineCount) * 100;
//
//        System.out.println("Число строк в файле: " + lineCount);
//        System.out.println("Googlebot: " + yandexBotPercentage);
//        System.out.println("Googlebot: " + googleBotCountPercentage);
//
//    }

    public static String searchBotInLine(String userAgent) {
        String bot = null;
        String firstBrackets = null;
        // находим бота в первых ()
        int startIndex = userAgent.indexOf("(");
        int endIndex = userAgent.indexOf(")");
        if (startIndex != -1 && endIndex != -1) {
            firstBrackets = userAgent.substring(startIndex + 1, endIndex);
        }
        if (firstBrackets != null) {
            String[] parts = firstBrackets.split(";");
            //Удаляем пробелы
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].replaceAll(" ", "");
            }

            //Удаляем слеш / у бота
            if (parts.length >= 2) {
                bot = parts[1];
                endIndex = bot.indexOf("/");
                if (endIndex != -1)
                    bot = bot.substring(0, endIndex);
            }
        }
        return bot;
    }

}