package oop_fundamentals.assigment_problems;

public class LibraryFineSystem {
    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "A", 18), new BookIssue("Effective Java", "B", 5),
            new BookIssue("Refactoring", "C", 0), new BookIssue("DSA Handbook", "D", 21),
            new BookIssue("Design Patterns", "E", 9)
        };

        for (BookIssue issue : issues) {
            String status = issue.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.printf("%s - %d days - %s%n", issue.title, issue.daysOverdue, status);
        }
        System.out.printf("Total fine collected: Rs %.1f%n", BookIssue.totalFineCollected(issues));
    }

    static class BookIssue {
        private final String title;
        private final String borrowerName;
        private final int daysOverdue;

        BookIssue(String title, String borrowerName, int daysOverdue) {
            this.title = title;
            this.borrowerName = borrowerName;
            this.daysOverdue = daysOverdue;
        }

        // A fine belongs to one particular issue, whereas the total combines many
        // issues and therefore belongs to the BookIssue class rather than one object.
        double fineAmount() { return daysOverdue > 0 ? daysOverdue * 5.0 : 0; }
        boolean isSeverelyOverdue() { return daysOverdue > 14; }

        static double totalFineCollected(BookIssue[] issues) {
            double total = 0;
            for (BookIssue issue : issues) {
                total += issue.fineAmount();
            }
            return total;
        }
    }
}
