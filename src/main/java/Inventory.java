import java.util.ArrayList;

public class Inventory<T extends InventoryItem> {
    ArrayList<T> inventoryList;
    public Inventory() {
        inventoryList = new ArrayList<T>();
    }
    public ArrayList<T> getInventoryList() {
        return inventoryList;
    }
    // TODO handle maxCapacity
    public void addItem(T item) {
        inventoryList.add(item);
    }
    public void delItem(T item) {
        inventoryList.remove(item); // kenapa ambiguous
    }
    public void printInventory() {
        for (T t : inventoryList) {
            System.out.println(t.printInfo());
        }
    }

    // TODO groupBy, sortBy
}