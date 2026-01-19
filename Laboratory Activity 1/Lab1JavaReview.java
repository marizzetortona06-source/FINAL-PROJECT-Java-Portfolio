import java.util.ArrayList;
import java.util.Scanner;

public class LibraryBookManagementSystem {
    private ArrayList<Book> books;
    private Scanner scanner;
    private static final int MAX_BOOKS = 5;
    
    
    static class Book {
        private String title;
        private String status;
        private int bookNumber;
        private static int nextBookNumber = 1;
        
        public Book(String title) {
            this.title = title;
            this.status = "Available";
            this.bookNumber = nextBookNumber++;
        }
        
        
        public String getTitle() { return title; }
        public String getStatus() { return status; }
        public int getBookNumber() { return bookNumber; }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        
        public String toString() {
            return "Book #" + bookNumber + ": " + title + " - " + status;
        }
    }
    
    
    public LibraryBookManagementSystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    
    public static void main(String[] args) {
        LibraryBookManagementSystem system = new LibraryBookManagementSystem();
        system.displayMainMenu();
    }
    
    
    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== Library Book Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Status");
            System.out.println("3. Show All Books");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Please select an option (1-5): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        updateBookStatus();
                        break;
                    case 3:
                        showBooks();
                        break;
                    case 4:
                        generateReport();
                        break;
                    case 5:
                        exitProgram();
                        return;
                    default:
                        System.out.println("Invalid selection! Please enter a number between 1-5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    
    public void addBook() {
        
        if (books.size() >= MAX_BOOKS) {
            System.out.println("Error: Maximum book limit (" + MAX_BOOKS + ") reached. Cannot add more books.");
            return;
        }
        
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        
        if (title.isEmpty()) {
            System.out.println("Error: Book title cannot be empty.");
            return;
        }
        
        Book newBook = new Book(title);
        books.add(newBook);
        
        System.out.println("Book added successfully!");
        System.out.println("Added: " + newBook);
    }
    
    
    public void updateBookStatus() {
        if (books.isEmpty()) {
            System.out.println("No books available in the system.");
            return;
        }
        
        System.out.print("Enter book number to update: ");
        try {
            int bookNumber = Integer.parseInt(scanner.nextLine());
            
            Book bookToUpdate = findBookByNumber(bookNumber);
            if (bookToUpdate == null) {
                System.out.println("Error: Invalid book number. Book not found.");
                return;
            }
            
            System.out.println("Current status: " + bookToUpdate.getStatus());
            System.out.println("Select new status:");
            System.out.println("1. Available");
            System.out.println("2. Borrowed");
            System.out.print("Enter choice (1-2): ");
            
            int statusChoice = Integer.parseInt(scanner.nextLine());
            String newStatus;
            
            switch (statusChoice) {
                case 1:
                    newStatus = "Available";
                    break;
                case 2:
                    newStatus = "Borrowed";
                    break;
                default:
                    System.out.println("Invalid status selection!");
                    return;
            }
            
            bookToUpdate.setStatus(newStatus);
            System.out.println("Book status updated successfully!");
            System.out.println("Updated: " + bookToUpdate);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid book number.");
        }
    }
    
    
    private Book findBookByNumber(int bookNumber) {
        for (Book book : books) {
            if (book.getBookNumber() == bookNumber) {
                return book;
            }
        }
        return null;
    }
    
    
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books currently stored in the system.");
            return;
        }
        
        System.out.println("\n=== All Books in Library ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    
    
    public void generateReport() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int borrowedBooks = 0;
        
        for (Book book : books) {
            if (book.getStatus().equals("Available")) {
                availableBooks++;
            } else if (book.getStatus().equals("Borrowed")) {
                borrowedBooks++;
            }
        }
        
        System.out.println("\n=== Library Book Report ===");
        System.out.println("Total number of books registered: " + totalBooks);
        System.out.println("Total number of available books: " + availableBooks);
        System.out.println("Total number of borrowed books: " + borrowedBooks);
        System.out.println("============================");
    }
    
    
    public void exitProgram() {
        System.out.println("Thank you for using the Library Book Management System!");
        System.out.println("Program terminated successfully. Goodbye!");
        scanner.close();
    }
}
