import java.io.*;
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
            int lineCount = 0, yandexBotCount = 0, googleBotCount = 0;
            Statistics statistics = new Statistics();
            while (true) {
                try {
                    if ((line = reader.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                int length = line.length();
                // Созданный класс исключения
                if (length > 1024) throw new LineTooLongException("Длина строки превышает допустимое значение");

                // число строк в файле
                lineCount++;

                LogEntry le = new LogEntry(line);
//                System.out.println(line);

                // Считаем количество ботов yandexBot и googleBot
                if (searchBotInLine(le.getUserAgent()) != null) {
                    if (searchBotInLine(le.getUserAgent()).equals("YandexBot")) yandexBotCount++;
                    if (searchBotInLine(le.getUserAgent()).equals("Googlebot")) googleBotCount++;
                }

                Statistics.addEntry(le);

            }

            // Находим долю ботов yandexBot и googleBot от общего числа запросов
            double yandexBotPercentage = ((double) yandexBotCount / lineCount) * 100;
            double googleBotCountPercentage = ((double) googleBotCount / lineCount) * 100;

            System.out.println("Число строк в файле: " + lineCount);
            System.out.println("Доля YandexBot: " + yandexBotPercentage);
            System.out.println("Доля Googlebot: " + googleBotCountPercentage);
            System.out.println("Общее количество трафика: " + statistics.getTotalTraffic());
            System.out.println("Среднее количество трафика в час: " + Statistics.getTrafficRate());
//            System.out.println("Страницы: " + Statistics.getPages());
            System.out.println("Не существующие страницы: " + Statistics.getNonExistingPages());
            System.out.println("ОС: " + Statistics.getOperatingSystem());
            System.out.println("Доля ОС: " + Statistics.calculateOsShares());
            System.out.println("Доля браузеров: " + Statistics.calculateBrowserShares());
            System.out.println("Количество ботов: " + Statistics.getBotCount());
            System.out.println("Среднее количество посещение: " + Statistics.getAverageVisits());
            System.out.println("Среднее количество ошибочных запросов: " + Statistics.getAverageErrorResponse());
            System.out.println("Количество пользователей: " + Statistics.getUsers().size());
            System.out.println("Средняя посещаемость одним пользователем: " + Statistics.getAverageVisitsPerUser());
            System.out.println("Посещений в секунду: " + Statistics.getPeakTraffic());
            System.out.println("Список сайтов : " + Statistics.getReferringDomains());
            System.out.println("Максимальное посещение одним пользователем : " + Statistics.getMaxUserVisits());


        }
    }
/*
C:\Users\snikolenko\Desktop\Курс по Java\access.log
*/

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