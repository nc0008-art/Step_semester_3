package replace_with_session_2_topic.class_problems;

public class MaskedPhoneNumberFormatter {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) return "Invalid phone number";
        for (int index = 0; index < phone.length(); index++) if (!Character.isDigit(phone.charAt(index))) return "Invalid phone number";
        StringBuilder masked = new StringBuilder("XXXXXX" + phone.substring(6));
        masked.insert(6, '-');
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
