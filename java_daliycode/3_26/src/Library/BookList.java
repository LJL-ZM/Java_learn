package Library;

public class BookList  {
    public Book[] GetList(){
        return bookList;
    }
    public int GetSize(){
        return size;
    }
    public void SetSizeP(){
        size++;
    }
    public void SetSizeD(){
        size--;
    }
    private final Book[] bookList = new Book[1010];
    int size = 0;
}
