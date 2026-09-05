package replace_with_session_2_topic.assigment_problems;

public class LibraryIsbnNormalizerValidator {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        return trimmed.length() < 3 ? trimmed : trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be exactly 13 characters";
        for (int index = 0; index < 3; index++) if (!Character.isLetter(code.charAt(index))) return "Invalid: publisher code must be 3 letters";
        for (int index = 3; index < code.length(); index++) if (!Character.isDigit(code.charAt(index))) return "Invalid: code body must contain only digits";
        StringBuilder display = new StringBuilder();
        display.append('[').append(code, 0, 3).append("] YEAR: ").append(code, 3, 7)
                .append(" | CATALOG: ").append(code, 7, 13);
        return display.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(normalizeCode(" pen2026004251 ")));
        System.out.println(validateAndFormat(normalizeCode("12N2026004251")));
    }
}
