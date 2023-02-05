import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        int decimals = 3;
        System.out.println("count numbers with unique digits: " + differentDigits(decimals));
    }

    static long differentDigits(int decimals) {
        return IntStream
                .range(1, (int) Math.pow(10, decimals))
                .mapToObj(n -> Integer.toString(n))
                .filter(s -> isUniqueSign(s))
                .count();
    }

    static boolean isUniqueSign(String str) {
        boolean isUnique = true;
        String tmpStr = str;
        HashSet<String> signsFromStr = new HashSet<>();
        while (tmpStr.length()>0) {
            signsFromStr.add(tmpStr.substring(0, 1));
            tmpStr = tmpStr.substring(1);
        }
        return signsFromStr.size()==str.length();
    }
}
