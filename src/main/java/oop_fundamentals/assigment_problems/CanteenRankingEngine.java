package oop_fundamentals.assigment_problems;

public class CanteenRankingEngine {
    public static void main(String[] args) {
        Canteen[] canteens = {
                new Canteen("HB3-C", "Spice Junction", 3),
                new Canteen("hb1-c", "Grand Mess", 5),
                new Canteen("HB2-C", "Southern Treats")
        };

        for (Canteen canteen : Canteen.rankCanteens(canteens)) {
            System.out.println(canteen.canteenCode);
        }
    }

    static class Canteen {
        private final String canteenCode;
        private final String canteenName;
        private final int trustScore;

        public Canteen(String canteenCode, String canteenName, int trustScore) {
            this.canteenCode = canteenCode;
            this.canteenName = canteenName;
            this.trustScore = trustScore;
        }

        public Canteen(String canteenCode, String canteenName) {
            this(canteenCode, canteenName, 3);
        }

        int compareTo(Canteen other) {
            int scoreComparison = Integer.compare(other.trustScore, trustScore);
            if (scoreComparison != 0) return scoreComparison;

            int codeComparison = canteenCode.compareToIgnoreCase(other.canteenCode);
            if (codeComparison != 0) return codeComparison;

            return Integer.compare(canteenName.length(), other.canteenName.length());
        }

        static Canteen[] rankCanteens(Canteen[] canteens) {
            if (canteens == null) return new Canteen[0];
            Canteen[] ranked = canteens.clone();
            for (int i = 0; i < ranked.length - 1; i++) {
                for (int j = 0; j < ranked.length - 1 - i; j++) {
                    if (ranked[j].compareTo(ranked[j + 1]) > 0) {
                        Canteen temporary = ranked[j];
                        ranked[j] = ranked[j + 1];
                        ranked[j + 1] = temporary;
                    }
                }
            }
            return ranked;
        }
    }
}
