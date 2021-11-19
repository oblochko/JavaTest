package tets.bentley_ottmann;

public class Point {
    private double x;
    private double y;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " : " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;
        if (obj.getClass() == this.getClass()) {
            Point point = (Point) obj;
            if (point.x == this.x && point.y == this.y)
                return true;
        }
        return false;
    }
}
