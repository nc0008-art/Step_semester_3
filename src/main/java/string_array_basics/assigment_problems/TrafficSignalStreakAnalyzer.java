package string_array_basics.assigment_problems;

public class TrafficSignalStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) { System.out.println("Signal log is empty."); return; }
        char longestColor = signalLog.charAt(0); int longest = 1, current = 1;
        for (int i = 1; i < signalLog.length(); i++) {
            current = signalLog.charAt(i) == signalLog.charAt(i - 1) ? current + 1 : 1;
            if (current > longest) { longest = current; longestColor = signalLog.charAt(i); }
        }
        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestColor, longest);
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
    }
}
