import java.util.HashSet;
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
        String tmpStr = str;
        HashSet<String> signsFromStr = new HashSet<>();
        while (tmpStr.length()>0) {
            signsFromStr.add(tmpStr.substring(0, 1));
            tmpStr = tmpStr.substring(1);
        }
        return signsFromStr.size()==str.length();
    }
}