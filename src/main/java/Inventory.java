import java.util.ArrayList;

public class Inventory<T> {
    ArrayList<T> inventoryList;
    public Inventory() {
        inventoryList = new ArrayList<T>();
    }
    public ArrayList<T> getInventoryList() {
        return inventoryList;
    }
    public void addItem(T item) {
        inventoryList.add(item);
    }
    public void delItem(T item) {
        inventoryList.remove(item); // kenapa ambiguous tadi
    }
    public void printInventory() {
        for (T t : inventoryList) {
            System.out.println(t.toString());
        }
    }


}