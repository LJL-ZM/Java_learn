public abstract class Shape {
    static class Point{
        int x, y;
    }

    static class line{
        Point start;
        Point end;
        int length;
    }

    public abstract double getS();

    public abstract double getC();
}
