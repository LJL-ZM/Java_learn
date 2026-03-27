package User;

import Library.BookList;
import Library.Book;

public abstract class User {
    public User(String name){
        this.name = name;
    }
    protected String name;
    public abstract void menu();
    public abstract int getRole();
    public abstract void doOpration(int op, BookList bookList, Book book, String name);
}
