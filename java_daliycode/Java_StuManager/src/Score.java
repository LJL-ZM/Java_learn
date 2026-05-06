import java.util.Objects;

public class Score {
    private String name;
    private int courseId;
    private int score;

    public Score(String name, int courseId, int score) {
        this.name = name;
        this.courseId = courseId;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Score score1 = (Score) o;
        return courseId == score1.courseId
                && score == score1.score
                && Objects.equals(name, score1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courseId, score);
    }
}