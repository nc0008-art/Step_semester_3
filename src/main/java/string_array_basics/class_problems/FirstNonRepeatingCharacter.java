package string_array_basics.class_problems;

public class FirstNonRepeatingCharacter {
    public static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[Character.MAX_VALUE + 1];
        for (char character : text.toCharArray()) frequency[character]++;
        for (char character : text.toCharArray()) if (frequency[character] == 1) return character;
        return '\0';
    }

    public static void main(String[] args) {
        String text = "swiss";
        char result = findFirstNonRepeatingChar(text);
        System.out.println(result == '\0' ? "No Non-Repeating Character Found" : "First Non-Repeating Character: '" + result + "'");
    }
}
