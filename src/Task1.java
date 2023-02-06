import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int uniqueChOrder = 2;
        String str = "StringStringXabc";
        System.out.println("Your input: " + str + "\n" + uniqueChOrder + " unique index: " + findSecondUniqueIndex(str, uniqueChOrder));
    }

    public static int findSecondUniqueIndex(String str, int uniqueChOrder) {
        LinkedHashMap<Integer, Character> indecedStr = getCharsInLinkedMap(str);
        return indecedStr.entrySet().stream()
                .filter(ch -> Collections.frequency(indecedStr.values(), ch.getValue())==1)
                .skip(uniqueChOrder-1)
                .mapToInt(k -> k.getKey())
                .findFirst()
                .orElse(-1);
    }

    static LinkedHashMap<Integer, Character> getCharsInLinkedMap(String str) {
        LinkedHashMap<Integer, Character> indecedStr = new LinkedHashMap<>();
        str = str.toLowerCase();
        for (int i=0; i<str.length(); i++) {
            indecedStr.put(i, str.charAt(i));
        }
        return indecedStr;
    }
}