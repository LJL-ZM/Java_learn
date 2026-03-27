package Library;

import java.util.Objects;

public class Book {
    public Book(String name, String author, int price){
        this.name = name;
        this.author = author;
        this.price = price;
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return price == book.price && isBorrowed == book.isBorrowed && Objects.equals(name, book.name) && Objects.equals(author, book.author);
        if(o instanceof Book){
            Book tmp = (Book)o;
            return (name.equals(tmp.name)) && (price == tmp.price) && (author.equals(tmp.author));
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, author, isBorrowed);
    }

    public String GetName(){
        return name;
    }
    public String GetAuthor(){
        return author;
    }
    public int GetPrice(){
        return price;
    }
    public boolean GetIsBorrowed(){
        return isBorrowed;
    }
    public void SetName(String name){
        this.name = name;
        return;
    }
    public void SetPrice(int price) {
        this.price = price;
        return;
    }
    public void SstAuthor(String author){
        this.author = author;
        return;
    }
    public void SetIsBorrowed(boolean isBorrowed){
        this.isBorrowed = isBorrowed;
        return;
    }
    private String name;
    private int price;
    private String author;
    boolean isBorrowed;
}
