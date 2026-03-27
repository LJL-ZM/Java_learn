package User;

import Library.Book;
import Library.BookList;
import Operator.ListOpService;
import Operator.ListOpServiceImpl;

public class NamalUser extends User{
    public NamalUser(String name){
        super(name);
    }
    @Override
    public void menu(){
        System.out.println("hello" + name + "!");
        System.out.println("*****************************************");
        System.out.println("**** 1 : Find         2 : Borrow ********");
        System.out.println("**** 3 : Return       0 : Exit  *********");
        System.out.println("*****************************************");
    }
    @Override
    public int getRole(){
        return 0;
    }

    @Override
    public void doOpration(int op, BookList bookList, Book book, String name){
        ListOpService listOp = new ListOpServiceImpl();
        switch(op){
            case 1 :{
                Book retBook = listOp.BookFindByName(bookList, name);
                if(retBook != null){
                    System.out.println("Find success :\n" + retBook.toString());
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
            case 2 : {
                if(listOp.Borrow(bookList, name)){
                    System.out.println("Borrow success!");
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
            case 3 : {
                if(listOp.Return(bookList, name)){
                    System.out.println("Return success!");
                } else {
                    System.out.println("Have no that book!");
                }
                break;
            }
        }
    }
}
