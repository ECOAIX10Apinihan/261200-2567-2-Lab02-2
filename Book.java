public class Book {
    String title;
    String author;
    double price;
    double discount; 
    
    Book(String title, String author, double price, double discount) {
        this.title = title;
        this.author = author;
        if (price < 0) {
            price = -price; // Convert negative prices to positive
        }
        this.price = price;
        if (discount >= 0 && discount < 100.00) {
            this.discount = discount;
            applyDiscount(); // Apply discount during initialization
        } else {
            this.discount = 0.0; // Invalid discounts default to 0
        }
    }

    Book(){
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.discount = 0.0;
    }
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Discount: " + discount+" %");
        System.out.println("Price: " + price);

    }

    void updatePrice(double newPrice){
        if(newPrice < 0){ 
            this.price = -1*newPrice;
        }
        this.price = newPrice;
        applyDiscount();
    }

    void applyDiscount() {
        if (discount > 0.0 && discount < 100.00) {
            price = ((100.00 - discount) / 100.00) * price;
        }
    }
    // Main method to test the Book class
    public static void main(String[] args) {
        // Test the default constructor
        Book unknownBook = new Book();
        unknownBook.displayDetails();

        // Test the parameterized constructor
        Book hp1Book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", -350.00,40.00);
        hp1Book.displayDetails();

        // Test the updatePrice method
        hp1Book.updatePrice(-32000.00);
        hp1Book.displayDetails();
    }
}
