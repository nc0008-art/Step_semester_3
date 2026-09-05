package string_array_basics.assigment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) { System.out.println("Sections must have equal item counts."); return; }
        int totalA = 0, totalB = 0, highest = Integer.MIN_VALUE, highestIndex = -1;
        String highestSection = "";
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i]; totalB += sectionB[i];
            if (sectionA[i] >= highest) { highest = sectionA[i]; highestSection = "Section A"; highestIndex = i; }
            if (sectionB[i] > highest) { highest = sectionB[i]; highestSection = "Section B"; highestIndex = i; }
        }
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, totalA == totalB ? "Balanced" : "Not Balanced", highest, highestSection, highestIndex + 1);
    }

    public static void main(String[] args) {
        analyzeInventory(new int[] {20, 15, 30}, new int[] {25, 10, 30});
    }
}
