import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // Запрос ввода пароля у пользователя
            System.out.print("Введите пароль: ");
            String userInput = scanner.nextLine();

            if(userInput.equalsIgnoreCase("break")){
                scanner.close();
                break;
            }
            // Проверка корректности пароля и вывод результата
            if (isValidPassword(userInput)) {
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль некорректен.");
            }
        }
    }

    private static boolean isValidPassword(String password) {
        // Регулярное выражение для проверки корректности пароля
        String passwordPattern = "^(?=.*[0-9])(?=.*[,./?*])(?=.*[A-Z]).{8,}$";

        // Создание объекта Pattern
        Pattern pattern = Pattern.compile(passwordPattern);

        // Создание объекта Matcher
        Matcher matcher = pattern.matcher(password);

        // Проверка на соответствие регулярному выражению
        return matcher.matches();
    }
}
