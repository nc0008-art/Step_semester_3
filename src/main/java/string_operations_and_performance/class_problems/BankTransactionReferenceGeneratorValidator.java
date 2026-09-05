package string_operations_and_performance.class_problems;

public class BankTransactionReferenceGeneratorValidator {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        return trimmed.length() < 3 ? trimmed : trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: reference must be exactly 14 characters";
        for (int index = 0; index < 3; index++) if (!Character.isLetter(reference.charAt(index))) return "Invalid: bank code must be 3 letters";
        for (int index = 3; index < reference.length(); index++) if (!Character.isDigit(reference.charAt(index))) return "Invalid: reference body must contain only digits";
        StringBuilder display = new StringBuilder();
        display.append('[').append(reference, 0, 3).append("] DATE: ")
                .append(reference, 3, 5).append('/').append(reference, 5, 7).append('/').append(reference, 7, 9)
                .append(" | SEQ: ").append(reference, 9, 14);
        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeReference(" hdf03022600042 ")));
        System.out.println(validateAndFormat(normalizeReference("12F03022600042")));
    }
}
