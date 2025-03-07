import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    /*
        complete the method below, so it will validate an email address
     */
    public boolean validateEmail(String email) {
        String regex = ".*@.*?\\..*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    /*
        this method should find a date in string
        note that it should be in british or american format
        if there's no match for a date, return null
     */
    public static String findDate(String string) {
        Pattern pattern = Pattern.compile("\\d{2}[\\/-]\\d{2}[\\/-]\\d{4}");
        Matcher matcher = pattern.matcher(string);
        if(matcher.find())
            return string.substring(matcher.start(), matcher.start() + 10);
        return "";
    }

    /*
        given a string, implement the method to detect all valid passwords
        then, it should return the count of them

        a valid password has the following properties:
        - at least 8 characters
        - has to include at least one uppercase letter, and at least a lowercase
        - at least one number and at least a special char "!@#$%^&*"
        - has no white-space in it
     */
    public int findValidPasswords(String string) {
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while(matcher.find())
            count++;

        return count;
    }

    /*
        you should return a list of *words* which are palindromic
        by word we mean at least 3 letters with no whitespace in it

        note: your implementation should be case-insensitive, e.g. Aba -> is palindrome
     */
    public static List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();

        String regex = "\\b[a-zA-Z]{3,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while(matcher.find()){
            String temp = matcher.group();
            if(temp.toLowerCase().equals(new StringBuilder(temp.toLowerCase()).reverse().toString()))
                list.add(temp);
        }
        
        return list;
    }

    public static void main(String[] args) {
        // you can test your code here
    }
}
