package hellolibrary;

public class Library {

    private Book [] myBooks;

    private int number;

    public Library() {
        myBooks = new Book[10];
        number = 0;
        System.out.println("Hello, I am a small library for at most 10 books.");
    }

    public void register(Book book) {
        myBooks[number] = book;
        number += 1;
        System.out.println("A new book is registered: " + book.getTitle());
    }

    public Book search(String title){
        for(Book b : myBooks) /*foreach-Schleife*/ {
            if (b != null && b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    public Book loan(String title) {
        Book b = search (title);
        if (b != null && !b.getIsLent()) {
            b.setIsLent(true);
            return b;
        }
        else {
            System.out.println("The Book "+title+" is not available. Sorry.");
            return null;
        }
    }
}
