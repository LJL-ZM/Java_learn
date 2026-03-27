package Operator;

import Library.Book;
import Library.BookList;

public class ListOpServiceImpl implements ListOpService {

    // 新增图书
    @Override
    public void BookAdd(BookList booklist, Book book) {
        int pos = Find(booklist, book.GetName());
        if(pos != -1){
            return;
        }
        booklist.GetList()[booklist.GetSize()] = book;
        booklist.SetSizeP();
    }

    // 删除图书
    @Override
    public boolean BookDel(BookList bookList, String name) {
        int pos = Find(bookList, name);
        if(pos == -1){
            return false;
        }
        // 数组前移覆盖
        for (int i = pos; i < bookList.GetSize() - 1; i++) {
            bookList.GetList()[i] = bookList.GetList()[i + 1];
        }

        // 最后一位置空，数量 -1
        bookList.GetList()[bookList.GetSize() - 1] = null;
        bookList.SetSizeD();

        return true;
    }

    @Override
    public Book BookFindByName(BookList bookList, String name) {
        if (bookList.GetSize() == 0) {
            return null;
        }

        for (int i = 0; i < bookList.GetSize(); i++) {
            if (bookList.GetList()[i].GetName().equals(name)) {
                return bookList.GetList()[i];
            }
        }
        return null;
    }

    @Override
    public boolean BookMov(BookList bookList, String name, Book book) {
        if (bookList.GetSize() == 0) {
            return false;
        }

        for (int i = 0; i < bookList.GetSize(); i++) {
            if (bookList.GetList()[i].GetName().equals(name)) {
                bookList.GetList()[i] = book;
                return true;
            }
        }
        return false;
    }

    public boolean Borrow(BookList bookList, String name){
        int pos = Find(bookList, name);
        if(pos == -1){
            return false;
        }
        bookList.GetList()[pos].SetIsBorrowed(true);
        return true;
    }

    public boolean Return(BookList bookList, String name){
        int pos = Find(bookList, name);
        if(pos == -1){
            return false;
        }
        bookList.GetList()[pos].SetIsBorrowed(false);
        return true;
    }
    private int Find(BookList bookList, String name){
        int pos = -1;
        for (int i = 0; i < bookList.GetSize(); i++) {
            if (bookList.GetList()[i].GetName().equals(name)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}