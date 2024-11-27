public class Book {
    String title;
    String author;
    double price; 
    
    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    void updatePrice(double newPrice){
        if(newPrice > 0){
            this.price = newPrice;
    } else{
        this.price = -1*newPrice;
    }
    }

    Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        if (price > 0) {
            this.price = price;
        }else{
            this.price = (double)-1*price;
        }
    }
    
    Book(){
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }
    // Main method to test the Book class
    public static void main(String[] args) {
        // Test the default constructor
        Book unknownBook = new Book();
        unknownBook.displayDetails();

        // Test the parameterized constructor
        Book hp1Book = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", -350.00);
        hp1Book.displayDetails();

        // Test the updatePrice method
        hp1Book.updatePrice(-32000.00);
        hp1Book.displayDetails();
    }
}
