import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос ввода номера телефона у пользователя
        while(true) {
            System.out.print("Введите номер телефона: ");
            String userInput = scanner.nextLine();
            if(userInput.equalsIgnoreCase("break")){
                scanner.close();
                break;
            }

            // Проверка корректности номера телефона и вывод результата
            if (isValidPhoneNumber(userInput)) {
                System.out.println("Номер телефона корректен.");
            } else {
                System.out.println("Номер телефона некорректен.");
            }
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Регулярное выражение для проверки корректности номера телефона
        String phonePattern = "^\\+?380[5-9]\\d\\d{7}$";

        // Создание объекта Pattern
        Pattern pattern = Pattern.compile(phonePattern);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(phoneNumber);

        // Проверка на соответствие регулярному выражению
        return matcher.matches();
    }
}
