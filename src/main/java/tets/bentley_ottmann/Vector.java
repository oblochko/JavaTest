package tets.bentley_ottmann;

public class Vector {
    private Point startPoint;
    private Point endPoint;
    private double xComponent;
    private double yComponent;

    public Vector(Point startPoint, Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        calculateComponent();
    }

    public Vector() {
        super();
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
        calculateComponent();
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
        calculateComponent();
    }

    public double getxComponent() {
        return xComponent;
    }

    public double getyComponent() {
        return yComponent;
    }

    private void calculateComponent() {
        xComponent = endPoint.getX() - startPoint.getX();
        yComponent = endPoint.getY() - startPoint.getY();
    }

    public Vector scl (double scalar) {
        double X = xComponent * scalar;
        double Y = yComponent * scalar;
        endPoint = new Point(startPoint.getX() + X, startPoint.getY() + Y);
        calculateComponent();
        return this;
    }

    @Override
    public String toString() {
        return "Vector [startPoint=" + startPoint + ", endPoint=" + endPoint + ", xComponent=" + xComponent
                + ", yComponent=" + yComponent + "]";
    }
}
