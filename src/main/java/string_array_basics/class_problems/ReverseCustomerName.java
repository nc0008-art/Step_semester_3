package string_array_basics.class_problems;

public class ReverseCustomerName {
    public static String reverseName(String customerName) {
        char[] characters = customerName.toCharArray();
        // Swap matching positions from the two ends of the name.
        for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
            char temporary = characters[left]; characters[left] = characters[right]; characters[right] = temporary;
        }
        return new String(characters);
    }

    public static void main(String[] args) {
        String customerName = "Anita Sharma";
        System.out.println("Original name: " + customerName);
        System.out.println("Reversed name: " + reverseName(customerName));
    }
}
