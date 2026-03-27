package Operator;

import Library.Book;
import Library.BookList;

public interface ListOpService {
    void BookAdd(BookList booklist, Book book);
    boolean BookDel(BookList bookList, String name);
    Book BookFindByName(BookList bookList, String name);
    boolean BookMov(BookList bookList, String name, Book book);
    boolean Borrow(BookList bookList, String name);
    boolean Return(BookList bookList, String name);
}
