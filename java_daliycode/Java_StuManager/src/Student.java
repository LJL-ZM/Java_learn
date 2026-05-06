import java.util.Objects;

public class Student extends Person{
    public static final int GRADE_ONE = 1;
    public static final int GRADE_TWO = 2;
    public static final int GRADE_THE = 3;
    public static final int GRADE_FOU = 4;
    protected String StudentId;
    protected int classId;
    protected int majorId;
    protected int grade;

    public Student(String name, int sex, int age, String studentId, int classId, int majorId, int grade) {
        super(name, sex, age);
        StudentId = studentId;
        this.classId = classId;
        this.majorId = majorId;
        this.grade = grade;
    }

    public Student() {}

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return classId == student.classId && majorId == student.majorId && grade == student.grade && Objects.equals(StudentId, student.StudentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), StudentId, classId, majorId, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentId='" + StudentId + '\'' +
                ", classId=" + classId +
                ", majorId=" + majorId +
                ", grade=" + grade +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
