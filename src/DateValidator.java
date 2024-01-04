import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            // Запрос ввода даты у пользователя
            System.out.print("Введите дату: ");
            String userInput = sc.nextLine();
            if (userInput.equalsIgnoreCase("break")) {
                sc.close();
                break;
            }

            // Проверка корректности даты и вывод результата
            if (isValidDate(userInput)) {
                System.out.println("Дата верна.");
                printDateInfo(userInput);
            } else {
                System.out.println("Дата некорректна.");
            }
        }
    }


    private static boolean isValidDate(String date) {
        // Регулярное выражение для проверки корректности даты
        String datePattern = "^((0[1-9]|1[0-2])[./]([0-9]{4}|[0-9]{2})|(0[1-9]|[12][0-9]|3[01])[./](0[1-9]|1[0-2])[./]([0-9]{4})|([0-9]{4}))?" +
                "( ([01]?[0-9]|2[0-3]):([0-5]?[0-9]))?$";




        // Создание объекта Pattern
        Pattern pattern = Pattern.compile(datePattern);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(date);

        // Проверка на соответствие регулярному выражению
        return matcher.matches();
    }


    private static void printDateInfo(String date) {
        // Извлечение компонентов даты
        String[] components = date.split("[./\\s:]");
        int day = components.length > 0 ? Integer.parseInt(components[0]) : 0;
        int month = components.length > 1 ? Integer.parseInt(components[1]) : 0;
        int year = components.length > 2 ? Integer.parseInt(components[2]) : 0;
        int hour = components.length > 3 ? Integer.parseInt(components[3]) : 0;
        int minute = components.length > 4 ? Integer.parseInt(components[4]) : 0;

        // Вывод информации о дате
        if (year != 0) {
            if (month != 0) {
                if (day != 0) {
                    System.out.println(day + " - день месяца");
                }
                System.out.println(month + " - месяц года");
                System.out.println(year + " - год");
            } else {
                System.out.println(year + " - год");
            }
        }

        // Вывод информации о времени
        if (hour != 0 || minute != 0) {
            System.out.println(hour + " часов " + minute + " минут");
        } else if (year != 0) {
            System.out.println("Время не указано");
        }
    }




}