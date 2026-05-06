import java.util.Arrays;

public class Class {
    public static final int NPOS = -1;
    private static final int DEFAULT_SIZE = 35;
    private int size;
    private Student[] students = new Student[DEFAULT_SIZE];
    private int id;

    Class(int id){
        this.id = id;
    }

    public int find(String name){
        for(int i = 0; i < size; i++){
            if(name.equals(students[i].getName())){
                return i;
            }
        }
        return NPOS;
    }

    public boolean add(Student student){
        String name = student.getName();
        int pos = find(name);
        if(pos != NPOS){
            return false;
        }
        //判满,每次加5
        if(size == students.length){
            students = Arrays.copyOf(students, students.length + 5);
        }
        students[size++] = student;
        return true;
    }

    public boolean erase(String name){
        int pos = find(name);
        if(pos == NPOS){
            return false;
        }
        for(int i = pos; i < --size; i++){
            students[i] = students[i + 1];
        }
        return true;
    }

    public boolean modify(Student student){
        String name = student.getName();
        int pos = find(name);
        if(pos == NPOS){
            return false;
        }
        students[pos] = student;
        return true;
    }

    public int getSize() {
        return size;
    }

    public Student getPos(int pos){
        return students[pos];
    }

    public int getId(){
        return id;
    }

}
