public class Circle {
    private final double PI = 3.14;
    int x, y;
    int r;
    Circle(int x, int y, int r){
        this.r = r;
        this.x = x;
        this.y = y;
    }

    Circle(){}

    pubili double getC(){
        return 2 * PI * r;
    }
    public double getS(){
        return PI * r * r;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
