import java.util.Arrays;

public class Grade {
    public static final int NPOS = -1;
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private Class[] classes = new Class[DEFAULT_SIZE];
    private int grade;

    public Grade(int grade) {
        this.grade = grade;
    }

    public int find(int classId) {
        for (int i = 0; i < size; i++) {
            if (classes[i].getId() == classId) {
                return i;
            }
        }
        return NPOS;
    }

    public boolean add(Class c) {
        int id = c.getId();
        int pos = find(id);
        if (pos != NPOS) {
            return false;
        }
        if (size == classes.length) {
            classes = Arrays.copyOf(classes, classes.length + 3);
        }
        classes[size++] = c;
        return true;
    }

    public boolean erase(int classId) {
        int pos = find(classId);
        if (pos == NPOS) {
            return false;
        }
        for (int i = pos; i < --size; i++) {
            classes[i] = classes[i + 1];
        }
        return true;
    }

    public Class getClassById(int classId) {
        int pos = find(classId);
        return pos == NPOS ? null : classes[pos];
    }

    public int getGrade() {
        return grade;
    }

    public int getSize() {
        return size;
    }

    public Class getPos(int pos) {
        return classes[pos];
    }
}