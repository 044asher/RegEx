import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your email: ");
            String userEmail = sc.nextLine();

            if(userEmail.equalsIgnoreCase("break")){
                sc.close();
                break;
            }

            if (checkEmailAddress(userEmail)) {
                System.out.println("Адрес " + userEmail + " написан правильно.");
            } else {
                System.out.println("Адрес " + userEmail + " не верен.");
            }

        }
    }
    private static boolean checkEmailAddress(String email) {
        String emailReg = "^[a-z0-9.]+@[a-z0-9-]+\\.[a-z0-9-.]+$";

        Pattern emailPattern = Pattern.compile(emailReg, Pattern.CASE_INSENSITIVE);
        Matcher emailMatcher = emailPattern.matcher(email);

        return emailMatcher.matches();
    }
}