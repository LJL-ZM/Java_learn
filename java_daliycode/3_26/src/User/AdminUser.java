package User;

import Library.BookList;
import Operator.ListOpService;
import Operator.ListOpServiceImpl;
import Library.Book;

import java.sql.SQLOutput;

public class AdminUser extends User{
    public AdminUser(String name){
        super(name);
    }
    @Override
    public void menu(){
        System.out.println("*****************************************");
        System.out.println("**** 1 : Add         2 : Del  ***********");
        System.out.println("**** 3 : Find        4 : Mov  ***********");
        System.out.println("****          0 : Exit         **********");
        System.out.println("*****************************************");
    }
    @Override
    public int getRole(){
        return 1;
    }
    @Override
    public void doOpration(int op, BookList bookList, Book book, String name){
        ListOpService listOp = new ListOpServiceImpl();
        switch(op){
            case 1 :{
                listOp.BookAdd(bookList, book);
                System.out.println("Add success!");
                break;
            }
            case 2 : {
                if(listOp.BookDel(bookList, name)){
                    System.out.println("Delete success!");
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
            case 3 : {
                Book retBook = listOp.BookFindByName(bookList, name);
                if(retBook != null){
                    System.out.println("Find success :\n" + retBook.toString());
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
            case 4 : {
                if(listOp.BookMov(bookList, name, book)){
                    System.out.println("Mov success!");
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
        }
    }
}
