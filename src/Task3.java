import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        int decimals = 3;
        System.out.println("count numbers with unique digits: " + differentDigits(decimals));
    }

    static long differentDigits(int decimals) {
        return IntStream
                .range(1, (int) Math.pow(10, decimals))
                .mapToObj(Integer::toString)
                .filter(Task3::isUniqueSign)
                .count();
    }

    static boolean isUniqueSign(String str) {
        Set<Character> signsFromStr = getCharsInSet(str);
        return signsFromStr.size()==str.length();
    }

    static Set<Character> getCharsInSet(String str) {
        Set<Character> charsInString = new HashSet<>();
        for (int i=0; i< str.length(); i++) {
            charsInString.add(str.charAt(i));
        }
        return charsInString;
    }
}