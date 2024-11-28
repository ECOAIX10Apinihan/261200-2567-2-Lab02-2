public class Book {
    String title;
    String author;
    double price;
    double discount;

    // Parameterized constructor
    Book(String title, String author, double price, double discount) {
        this.title = title;
        this.author = author;

        // Ensure the price is positive ทำให้เป็นบวก
        this.price = Math.abs(price);

        // Validate and set the discount ส่วนลดควรถูกคำนวนไหม
        if (discount >= 0 && discount <= 100.00) {
            this.discount = discount;
            applyDiscount(); // Apply discount during initialization (func คำนวนส่วนลด อัปเดตราคา ) 
        } else {
            this.discount = 0.0; // Default discount to 0 if invalid (set 0 ถ้า ไม่มีส่วนลด)
        }
    }

    // Default constructor 
    Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.discount = 0.0;
    }

    // Method to display book details แสดงผล
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Discount: " + discount + " %");
        System.out.println("Price: " + price);
    }

    // Method to update the book's price อัปเดตเงิน
    void updatePrice(double newPrice) {
        // Ensure the price is positive ทำให้เป็นบวก มาจาก math absolute = | number |
        this.price = Math.abs(newPrice);

        // Reapply the discount after updating the price 
        applyDiscount();
    }

    // Method to apply the discount to the price (func คำนวนส่วนลด อัปเดตราคา )
    void applyDiscount() {
        if (discount >= 0.0 && discount <= 100.00) {
            price = ((100.00 - discount) / 100.00) * price;
        } else {
            // Display a message if the discount is invalid 
            System.out.println("Discount must be between 0.0% and 100.0%");
        }
    }

    // Main method to test the Book class
    public static void main(String[] args) {
        // Test the default constructor
        Book unknownBook = new Book();
        unknownBook.displayDetails();

        // Test the parameterized constructor with negative price and invalid discount
        Book hp1Book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", -350.00, -40.00);
        hp1Book.displayDetails();

        // Test the updatePrice method with a negative price
        hp1Book.updatePrice(-32000.00);
        hp1Book.displayDetails();

        // Test the parameterized constructor with valid discount
        Book validBook = new Book("Valid Book", "Author 2", 500.00, 25.00);
        validBook.displayDetails();

        // Test the updatePrice method with a positive price
        validBook.updatePrice(600.00);
        validBook.displayDetails();
    }
}
