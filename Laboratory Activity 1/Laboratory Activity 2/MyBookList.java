import java.util.ArrayList;
import java.util.List;

public class MyBookList {
    public static void main(String[] args) {
        
        Book book1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 1997, 336);
        Book book2 = new Book("The Power of Habit", "Charles Duhigg", 2012, 371);
        Book book3 = new Book("Atomic Habits", "James Clear", 2018, 320);
        Book book4 = new Book("Java Programming", "John Doe", 2020, 500);
        Book book5 = new Book("Hunger Games: Catching Fire", "Suzanne Collins", 2009, 391);
        
        
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        
        
        System.out.println("=== ALL BOOKS ===");
        displayAllBooks(bookList);
        
        
        System.out.println("\n=== READING PROGRESS ===");
        book1.changePage(50);
        book3.changePage(100);
        book5.changePage(27);
        
        System.out.println("After changing pages:");
        book1.details();
        book3.details();
        book5.details();
        
        
        System.out.println("\n=== UPDATING BOOK INFO ===");
        book4.setAuthor("Jane Smith");
        System.out.println("After changing author:");
        book4.details();
        
        
        System.out.println("\n=== BOOKS PUBLISHED AFTER 2010 ===");
        filterBooksByYear(bookList, 2010);
        
        
        System.out.println("\n=== NEWEST BOOK ===");
        Book newestBook = findNewestBook(bookList);
        if (newestBook != null) {
            System.out.println(newestBook.getTitle() + " (" + newestBook.getPublishDate() + ")");
        }
        
        System.out.println("\n=== BOOKS BY AUTHOR ===");
        searchByAuthor(bookList, "James Clear");
    }
    
    
    public static void displayAllBooks(List<Book> books) {
        for (Book book : books) {
            book.details();
        }
    }
    
    
    public static void filterBooksByYear(List<Book> books, int year) {
        boolean found = false;
        for (Book book : books) {
            if (book.getPublishDate() > year) {
                System.out.println("- " + book.getTitle() + " (" + book.getPublishDate() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found after " + year);
        }
    }
    
    
    public static Book findNewestBook(List<Book> books) {
        if (books.isEmpty()) return null;
        
        Book newest = books.get(0);
        for (Book book : books) {
            if (book.getPublishDate() > newest.getPublishDate()) {
                newest = book;
            }
        }
        return newest;
    }
    
    
    public static void searchByAuthor(List<Book> books, String authorName) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                System.out.println("- " + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by " + authorName);
        }
    }
}
