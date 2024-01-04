package Examples;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question3_4_5 {
    public static void main(String[] args) {
        String pattern1 = "sp.ce";
        System.out.println("Pattern 1: ");
        testRegex(pattern1, "space");
        testRegex(pattern1, "sp1ce");
        testRegex(pattern1, "spaace");
        testRegex(pattern1, "sp😘ce");
        System.out.println();

        String pattern2 = "colou?r";
        System.out.println("Pattern 2: ");
        testRegex(pattern2, "color");
        testRegex(pattern2, "colour");
        testRegex(pattern2, "colouar");
        System.out.println();

        String pattern3 = "[eiou]";
        System.out.println("Pattern 3:");
        testRegex(pattern3, "apple");
        testRegex(pattern3, "banana");
        testRegex(pattern3, "grape");
        System.out.println();

        String pattern4 = "\\d+";
        System.out.println("Pattern 4:");
        testRegex(pattern4, "123");
        testRegex1(pattern4, "123");

        testRegex(pattern4, "456abc");
        testRegex1(pattern4, "456abc");

        testRegex(pattern4, "abc");
        testRegex1(pattern4, "abc");
        System.out.println();

        String pattern5 = "[a-z]+";
        testRegex1(pattern5, "Space");
        testRegex1(pattern5, "lab");
        testRegex1(pattern5, "world1");
        System.out.println();

        String pattern6 = "[1-5a-z]+";
        testRegex1(pattern6, "regular1");
        testRegex1(pattern6, "regular6");
        testRegex1(pattern6, "1789");
    }

    private static void testRegex(String pattern, String input){
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        System.out.println("Input: " + input);
        System.out.println("Matches: " + matcher.find());
        System.out.println();
    }
    private static void testRegex1(String pattern, String input){
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);
        System.out.println("Input: " + input);
        System.out.println("Matches: " + matcher.matches());
        System.out.println();
    }
}
