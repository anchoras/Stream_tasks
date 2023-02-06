import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        String[] strings = {"http://google.com/4", "http://google.com/s/2/4/6", "http://yandex.ru", "http://google.com", "http://paizo.com/hello"};
        System.out.println(uniqueDomains(strings));
    }

    static Map<String, Long> uniqueDomains(String[] strings) {
        return Arrays.stream(strings)
                .map(s -> s.split("://")[1])
                .map(s -> s.split("/")[0])
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    }
}