import java.util.Objects;

public class Person {
    public static final int MAN = 1;
    public static final int WOMAN = 0;
    protected String name;
    protected int sex;
    protected int age;

    public Person(String name, int sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sex == person.sex && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}
