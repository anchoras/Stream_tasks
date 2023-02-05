import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = {"http://google.com/4", "http://google.com/s/2/4/6", "http://yandex.ru", "http://google.com", "http://paizo.com/hello"};
        System.out.println(uniqueDomains(strings));

    }
    static HashMap<String, Long> uniqueDomains(String[] strings) {
        return (HashMap<String, Long>) Arrays.stream(strings)
                .map(s -> s.substring(7))
                .map(s -> s.substring(0, myIndexOf(Pattern.compile("/"), s)))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    }
    static int myIndexOf(Pattern pattern, String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.start() : (str.length());
    }
}