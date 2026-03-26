package Library;

public class Book {
    Book(String name, String author, int price){
        this.name = name;
        this.author = author;
        this.price = price;
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
    public void SetName(String name){
        this.name = name;
        return;
    }
    public void SetPrice(int price) {
        this.price = price;
        return
    }
    public void SstAuthor(String author){
        this.author = author;
        return;
    }
    private String name;
    private int price;
    private String author;
}
