package info.trongdat.readbook.Adapters;

import java.util.ArrayList;

import info.trongdat.readbook.Entities.Book;

/**
 * Created by Qui96hy on 10/2/2016.
 */
public class BookData {
    public String[] placeNameArray = {"Bora Bora", "Canada", "Dubai", "Hong Kong", "Iceland", "India", "Kenya", "London", "Switzerland", "Sydney"};

    public ArrayList<Book> placeList() {
        Book book = new Book();
        ArrayList<Book> list = new ArrayList<>();
        for (int i = 0; i < placeNameArray.length; i++) {
            book.setBookName(placeNameArray[i].toString());
            book.setImageName(placeNameArray[i].replaceAll("\\s+", "").toLowerCase());

            list.add(book);
        }
        return (list);
    }

    static ArrayList<Book> list = new ArrayList<>();
    static String[] books = {"Tạm biệt xe đạp", "Original working", "Concept Making", "Tôi và Paris", "Hoàng tử và chú bé", "Nghệ thuật giao tiếp"};
    public static ArrayList<Book> getBooks() {
        Book book = new Book();

        for (int i = 0; i < books.length; i++) {
            book.setBookName(books[i]);
            list.add(book);
        }
        return (list);
    }

}
