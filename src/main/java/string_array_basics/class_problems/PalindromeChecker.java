package string_array_basics.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        for (int left = 0, right = text.length() - 1; left < right; left++, right--)
            if (text.charAt(left) != text.charAt(right)) return false;
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;
        return text.charAt(left) == text.charAt(right) && isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] reversed = text.toCharArray();
        for (int left = 0, right = reversed.length - 1; left < right; left++, right--) {
            char temporary = reversed[left]; reversed[left] = reversed[right]; reversed[right] = temporary;
        }
        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {
        String text = "madam";
        System.out.println("Text: " + text);
        System.out.println("Iterative: " + isPalindromeIterative(text));
        System.out.println("Recursive: " + isPalindromeRecursive(text));
        System.out.println("Array Reversal: " + isPalindromeArrayReversal(text));
    }
}
