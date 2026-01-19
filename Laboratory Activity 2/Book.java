class Book {
    private String title;
    private String author;
    private int publishDate;
    private int currentPage;
    private int totalPages;
    
    public Book(String title, String author, int publishDate, int totalPages) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.currentPage = 0;
        this.totalPages = totalPages;
    }
    
    public void details() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Current Page: " + currentPage + " / " + totalPages);
        System.out.println(); 
    }
    
    public boolean changePage(int page) {
        if (page >= 0 && page <= totalPages) {
            this.currentPage = page;
            return true;
        }
        System.out.println("Invalid page number!");
        return false;
    }
    
    public void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
        } else {
            System.out.println("Already at the last page!");
        }
    }
    
    public void previousPage() {
        if (currentPage > 0) {
            currentPage--;
        } else {
            System.out.println("Already at the first page!");
        }
    }
    
    
    public int getPublishDate() {
        return publishDate;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public int getTotalPages() {
        return totalPages;
    }
    
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
}
