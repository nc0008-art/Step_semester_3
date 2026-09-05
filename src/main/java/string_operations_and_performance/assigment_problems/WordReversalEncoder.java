package string_operations_and_performance.assigment_problems;

public class WordReversalEncoder {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord = new StringBuilder();
            for (int character = words[index].length() - 1; character >= 0; character--) reversedWord.append(words[index].charAt(character));
            if (index > 0) result.append(' ');
            result.append(reversedWord);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
