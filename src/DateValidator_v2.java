import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator_v2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Запрос ввода даты у пользователя
            System.out.print("Введите дату: ");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("break")) {
                sc.close();
                break;
            }

            // Проверка корректности даты и вывод результата
            String dateInfo = getDateInfo(userInput);
            if (dateInfo != null) {
                System.out.println("Дата верна.");
                System.out.println(dateInfo);
            } else {
                System.out.println("Дата некорректна.");
            }
        }
    }

    private static String getDateInfo(String date) {
        // Регулярные выражения для разных форматов даты
        String dayMonthYearPattern = "^(0[1-9]|[1-2][0-9]|3[0-1])[./](0[1-9]|1[1-2])[./]([0-9]{4})$";
        String monthYearPattern = "^(0[1-9]|1[0-2])[./]([0-9]{4})$";
        String yearPattern = "^([0-9]{4})$";
        String dateTimePattern = "^(0[1-9]|[1-2][0-9]|3[0-1])[./](0[1-9]|1[1-2])[./]([0-9]{4}) (20|21|22|23|[01]?[0-9]):([0-5]?[0-9])$";

        // Создание объекта Pattern
        Pattern dayMonthYear = Pattern.compile(dayMonthYearPattern);
        Pattern monthYear = Pattern.compile(monthYearPattern);
        Pattern year = Pattern.compile(yearPattern);
        Pattern dateTime = Pattern.compile(dateTimePattern);

        // Создание объекта Matcher
        Matcher matcherDayMonthYear = dayMonthYear.matcher(date);
        Matcher matcherMonthYear = monthYear.matcher(date);
        Matcher matcherYear = year.matcher(date);
        Matcher matcherDateTime = dateTime.matcher(date);

        // Проверка на соответствие регулярным выражениям
        if (matcherDayMonthYear.matches()) {
            return printDateInfo(date);
        } else if (matcherMonthYear.matches()) {
            return printMonthYearInfo(date);
        } else if (matcherYear.matches()) {
            return printYearInfo(date);
        } else if (matcherDateTime.matches()) {
            return printDateTimeInfo(date);
        }


        return null; // Возвращаем null в случае некорректного формата даты
    }

    private static String printDateInfo(String date) {
        String[] components = date.split("[./]");
        int day = Integer.parseInt(components[0]);
        int month = Integer.parseInt(components[1]);
        int year = Integer.parseInt(components[2]);

        // Проверка на корректность месяца
        if (month < 1 || month > 12) {
            return null;
        }

        return (day + " - день месяца\n" + month + " - месяц года\n" + year + " - год");
    }



    private static String printMonthYearInfo(String date) {
        String[] components = date.split("[./]");
        int month = Integer.parseInt(components[0]);
        int year = Integer.parseInt(components[1]);
        return (month + " - месяц года\n" + year + " - год");
    }

    private static String printYearInfo(String date) {
        int year = Integer.parseInt(date);
        return (year + " - год");
    }

    private static String printDateTimeInfo(String dateTime) {
        String[] components = dateTime.split("[./\\s:]");
        int day = Integer.parseInt(components[0]);
        int month = Integer.parseInt(components[1]);
        int year = Integer.parseInt(components[2]);
        int hour = Integer.parseInt(components[3]);
        int minute = Integer.parseInt(components[4]);

        // Проверка на корректность месяца и часа
        if (month < 1 || month > 12 || hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            return null;
        }

        return (day + " - день месяца\n" + month + " - месяц года\n" + year + " - год\n" + hour + " час(-ов)(-а) " + minute + " минут(ы).");
    }

}
