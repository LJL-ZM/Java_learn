import java.util.Arrays;

public class CourseManager {
    public static final int NPOS = -1;
    private static final int DEFAULT_SIZE = 35;
    private int size;
    private Course[] courses = new Course[DEFAULT_SIZE];

    CourseManager(){}

    public int find(int id){
        for(int i = 0; i < size; i++){
            if(id == courses[i].getId()){
                return i;
            }
        }
        return NPOS;
    }

    public boolean add(Course course){
        int id = course.getId();
        int pos = find(id);
        if(pos != NPOS){
            return false;
        }
        if(size == courses.length){
            courses = Arrays.copyOf(courses, courses.length + 5);
        }
        courses[size++] = course;
        return true;
    }

    public boolean erase(int id){
        int pos = find(id);
        if(pos == NPOS){
            return false;
        }
        for(int i = pos; i < --size; i++){
            courses[i] = courses[i + 1];
        }
        return true;
    }

    public boolean modify(Course course){
        int id = course.getId();
        int pos = find(id);
        if(pos == NPOS){
            return false;
        }
        courses[pos] = course;
        return true;
    }

    public int getSize() {
        return size;
    }

    public Course getPos(int pos){
        return courses[pos];
    }
}