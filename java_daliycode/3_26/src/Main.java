import Library.*;
import User.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static User logIn(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = scan.next();
        System.out.println("Please enter your role:");
        System.out.println("1->admin     0->normal");
        int role = scan.nextInt();
        if(role == 1){
            return new AdminUser(name);
        } else {
            return new NamalUser(name);
        }
    }
    public static void main(String[] args) {
        User user = logIn();
        BookList booklist = new BookList();
        while(true)
        {
            user.menu();
            Scanner scan = new Scanner(System.in);
            int op = scan.nextInt();
            if(op == 0){
                break;
            }
            System.out.println("Please enter bookName");
            String bookName = scan.next();
            scan.nextLine();
            Book book = null;
            if(user.getRole() == 1 && (op == 1 || op == 4)){
                System.out.println("Please enter bookPrice:");
                int bookPrice = scan.nextInt();
                System.out.println("Please enter bookAuthor:");
                String bookAuthor = scan.next();
                book = new Book(bookName, bookAuthor, bookPrice);
            }
            user.doOpration(op, booklist, book, bookName);
        }
    }
}