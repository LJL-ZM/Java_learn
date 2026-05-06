public class Major {
    private Grade[] grades = new Grade[4];

    public Major() {
        grades[0] = new Grade(1);
        grades[1] = new Grade(2);
        grades[2] = new Grade(3);
        grades[3] = new Grade(4);
    }

    public Grade getGrade(int grade) {
        for (Grade g : grades) {
            if (g.getGrade() == grade) {
                return g;
            }
        }
        return null;
    }
}