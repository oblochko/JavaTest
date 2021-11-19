package tets.bentley_ottmann;


import java.util.Comparator;

public class Segment implements Comparable<Segment> {
    private Point first;
    private Point second;

    public Segment(Point point1, Point point2){
        if(point1.getY() == point2.getY()){
            if(point1.getX() < point2.getX()) {
                this.first = point1;
                this.second = point2;
            } else {
                this.first = point2;
                this.second = point1;
            }
        }

        if(point1.getY() > point2.getY()) {
            this.first = point1;
            this.second = point2;
        } else {
            this.first = point2;
            this.second = point1;
        }
    }

    public Point getFirst() {
        return first;
    }

    public void setFirst(Point first) {
        this.first = first;
    }

    public Point getSecond() {
        return second;
    }

    public void setSecond(Point second) {
        this.second = second;
    }

    @Override
    public int compareTo(Segment o2) {
        if(this.equals(o2)) return 0;
        if(this.getFirst().getX() > o2.getFirst().getX()) return 1;
        if(this.getFirst().getX() < o2.getFirst().getX()) return -1;
        if(this.getSecond().getX() > o2.getSecond().getX())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Point first: " + first.getX() + " : " + first.getY() + " Point second: " + second.getX() + " : " + second.getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;

        if (obj.getClass() == this.getClass()) {
            Segment segment = (Segment) obj;
            if (first.equals(segment.getFirst())
                    && second.equals(segment.getSecond()) )
                return true;
        }
        return false;
    }
}
