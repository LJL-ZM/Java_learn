import java.util.Objects;

public class Course {
    private String name;
    private int id;
    private int credit;

    public Course(String name, int id, int credit) {
        this.name = name;
        this.id = id;
        this.credit = credit;
    }

    public Course(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && credit == course.credit && Objects.equals(name, course.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, credit);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", credit=" + credit +
                '}';
    }
}
