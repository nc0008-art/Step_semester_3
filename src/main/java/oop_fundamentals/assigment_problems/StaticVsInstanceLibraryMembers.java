package oop_fundamentals.assigment_problems;

public class StaticVsInstanceLibraryMembers {
    public static void main(String[] args) {
        BrokenLibraryMember firstBroken = new BrokenLibraryMember("Aditi", 2);
        BrokenLibraryMember secondBroken = new BrokenLibraryMember("Rohan", 1);
        System.out.println("Broken version:");
        System.out.println(firstBroken.name);
        System.out.println(secondBroken.name);

        LibraryMember aditi = new LibraryMember("Aditi", 2);
        LibraryMember rohan = new LibraryMember("Rohan", 1);
        System.out.println("Fixed version:");
        aditi.printMemberCard();
        rohan.printMemberCard();
        LibraryMember.printTotalMembers();
    }

    static class BrokenLibraryMember {
        // name, memberId, and booksIssued describe one member, so each must be an
        // instance field. Making any of them static shares it across every member.
        static String name;
        static String memberId;
        static int booksIssued;

        BrokenLibraryMember(String name, int booksIssued) {
            BrokenLibraryMember.name = name;
            BrokenLibraryMember.booksIssued = booksIssued;
        }
    }

    static class LibraryMember {
        private final String name;
        private final String memberId;
        private final int booksIssued;
        private static final String libraryName = "SRM Library";
        private static int memberCount;

        LibraryMember(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
            memberId = "LM-" + (1000 + ++memberCount);
        }

        void printMemberCard() {
            System.out.println(name + " | " + memberId);
        }

        static void printTotalMembers() {
            System.out.println("Total members: " + memberCount);
        }
    }
}
