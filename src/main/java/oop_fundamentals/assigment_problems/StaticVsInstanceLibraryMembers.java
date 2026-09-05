package oop_fundamentals.assigment_problems;

public class StaticVsInstanceLibraryMembers {
    public static void main(String[] args) {
        BrokenLibraryMember firstBroken = new BrokenLibraryMember("Aditi", 2);
        BrokenLibraryMember secondBroken = new BrokenLibraryMember("Rohan", 1);
        System.out.println("Broken version:"); System.out.println(firstBroken.name); System.out.println(secondBroken.name);
        LibraryMember aditi = new LibraryMember("Aditi", 2); LibraryMember rohan = new LibraryMember("Rohan", 1);
        System.out.println("Fixed version:"); aditi.printMemberCard(); rohan.printMemberCard(); LibraryMember.printTotalMembers();
    }
    static class BrokenLibraryMember { // These fields must vary per member, so static makes them incorrectly shared.
        static String name, memberId; static int booksIssued; BrokenLibraryMember(String name, int booksIssued) { BrokenLibraryMember.name = name; BrokenLibraryMember.booksIssued = booksIssued; } }
    static class LibraryMember { final String name, memberId; final int booksIssued; static final String libraryName = "SRM Library"; static int memberCount;
        LibraryMember(String name, int booksIssued) { this.name = name; this.booksIssued = booksIssued; memberId = "LM-" + (1000 + ++memberCount); }
        void printMemberCard() { System.out.println(name + " | " + memberId); } static void printTotalMembers() { System.out.println("Total members: " + memberCount); } }
}
