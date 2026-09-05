package string_operations_and_performance.assigment_problems;

public class ProductInventoryCsvParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) { System.out.println("Invalid Record"); return; }
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", fields[0], fields[1], fields[2]);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
    }
}
