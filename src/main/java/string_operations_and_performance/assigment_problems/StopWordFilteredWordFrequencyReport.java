package string_operations_and_performance.assigment_problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFilteredWordFrequencyReport {
    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) if (stopWord.equals(word)) return true;
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : cleaned.split("\\s+")) if (!word.isEmpty() && !isStopWord(word)) frequencies.merge(word, 1, Integer::sum);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequencies.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> entry : entries) System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
