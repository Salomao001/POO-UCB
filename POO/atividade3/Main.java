import java.util.ArrayList;
import java.util.Scanner;

class Item {
    String name;
    int quantity;

    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}

class Inventory {
    ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(String name, int quantity) {
        Item newItem = new Item(name, quantity);
        items.add(newItem);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.name.equals(name));
    }

    public void updateQuantity(String name, int newQuantity) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                item.quantity = newQuantity;
                break;
            }
        }
    }

    public void listItems() {
        System.out.println("Inventory:");
        for (Item item : items) {
            System.out.println(item.name + " - Quantity: " + item.quantity);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. List Items");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String itemName = scanner.nextLine();
                    System.out.print("Enter item quantity: ");
                    int itemQuantity = scanner.nextInt();
                    inventory.addItem(itemName, itemQuantity);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    inventory.removeItem(itemToRemove);
                    break;

                case 3:
                    System.out.print("Enter item name to update quantity: ");
                    String itemToUpdate = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    inventory.updateQuantity(itemToUpdate, newQuantity);
                    break;

                case 4:
                    inventory.listItems();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}