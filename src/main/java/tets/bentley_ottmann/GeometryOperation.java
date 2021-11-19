package tets.bentley_ottmann;

import java.util.List;

public class GeometryOperation {
    public static final double M_PI = 3.14159;
    public static double vectorCrossProduct(Vector vector1, Vector vector2) {
        return vector1.getxComponent() * vector2.getyComponent() - vector2.getxComponent() * vector1.getyComponent();
    }

    public static boolean rangeIntersection(double a, double b, double c, double d) {
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        if (c > d) {
            double temp = c;
            c = d;
            d = temp;
        }
        return Math.max(a, c) <= Math.min(b, d);
    }

    public static boolean boundingBox(Segment ab, Segment cd) {
        boolean xRangeIntersection = rangeIntersection(ab.getFirst().getX(), ab.getSecond().getX(),
                cd.getFirst().getX(), cd.getSecond().getX());
        boolean yRangeIntersection = rangeIntersection(ab.getFirst().getY(), ab.getSecond().getY(),
                cd.getFirst().getY(), cd.getSecond().getY());
        return xRangeIntersection && yRangeIntersection;
    }

    public static boolean checkSegmentIntersection(Segment ab, Segment cd) {
        if (!boundingBox(ab, cd)) {
            return false;
        }
        Vector vAB = new Vector(ab.getFirst(), ab.getSecond());
        Vector vAC = new Vector(ab.getFirst(), cd.getFirst());
        Vector vAD = new Vector(ab.getFirst(), cd.getSecond());

        Vector vCD = new Vector(cd.getFirst(), cd.getSecond());
        Vector vCA = new Vector(cd.getFirst(), ab.getFirst());
        Vector vCB = new Vector(cd.getFirst(), ab.getSecond());

        double d1 = vectorCrossProduct(vAB, vAC);
        double d2 = vectorCrossProduct(vAB, vAD);

        double d3 = vectorCrossProduct(vCD, vCA);
        double d4 = vectorCrossProduct(vCD, vCB);
        return ((d1 <= 0 && d2 >= 0) || (d1 >= 0 && d2 <= 0)) && ((d3 <= 0 && d4 >= 0) || (d3 >= 0 && d4 <= 0));
    }

    public static Point pointOfIntersection(Segment ab, Segment cd){
        Vector vAB = new Vector(ab.getFirst(), ab.getSecond());
        Vector vAC = new Vector(ab.getFirst(), cd.getFirst());
        Vector vAD = new Vector(ab.getFirst(), cd.getSecond());

        double d1 = vectorCrossProduct(vAB, vAC);
        double d2 = vectorCrossProduct(vAB, vAD);

        double k = Math.abs(d2 / d1);

        Vector vDC = new Vector(cd.getSecond(), cd.getFirst());

        vDC.scl(1 / (k + 1)*k);

        return vDC.getEndPoint();
    }

    public static boolean isSegmentContainsPoint(Segment segment, Point C){
        Vector vAB = new Vector(segment.getFirst(), segment.getSecond());
        Vector vAC = new Vector(segment.getFirst(), C);
        Vector vCB = new Vector(C, segment.getSecond());

        return (Math.abs(vAC.getxComponent()) + Math.abs(vCB.getxComponent()) == Math.abs(vAB.getxComponent())
                && Math.abs(vAC.getyComponent()) + Math.abs(vCB.getyComponent()) == Math.abs(vAB.getyComponent()));
    }

    public static  boolean isOnTheBorder(Segment segment, Point point) {
        return segment.getSecond().equals(point);
    }

    public static Segment rightSegment(List<Segment> list){
        for(Segment s : list) {

        }
        return list.get(0);
    }

    public static double getAngle(Segment s1, Segment s2) {
        double boxX = s1.getFirst().getX();
        double boxY = s1.getFirst().getY();

// v2 user touch
        double touchX = s2.getFirst().getX();
        double touchY = s2.getFirst().getY();

        return  180.0 / Math.PI * Math.atan2(boxX - touchX, touchY - boxY);
    }

    public static double getAngle(Point A, Point B, Point C) {
        Point AB = new Point(B.getX() - A.getX(), B.getY() - A.getY());
        Point AC = new Point(C.getX() - A.getX(), C.getY() - A.getY());

        System.out.println(180.0 / Math.PI * Math.atan2(AB.getY() - AC.getY(), AB.getX() - AC.getX()));
        System.out.println(normalize(180.0 / Math.PI * Math.atan2(AC.getY(), AC.getX()) - Math.atan2(AB.getY(), AB.getX())));
        return 0;
    }

    public static double normalize(double angle) {
        if (angle > M_PI) {
            angle -= 2 * M_PI;
        }
        else if (angle <= -M_PI) {
            angle += 2 * M_PI;
        }
        return angle;
    }

    public static double getAngle2(Point A, Point B, Point C) {
        Vector vAB = new Vector(A, B);
        Vector vAC = new Vector(A, C);

        System.out.println(Math.atan2(cross(vAB,vAC), dot(vAB,vAC))) ;
        System.out.println(180.0 / Math.PI * Math.atan2(cross(vAB,vAC), dot(vAB,vAC))) ;
        return 0;
    }

    public static double dot(Vector vAB, Vector vAC)
    {
        return vAB.getxComponent() * vAC.getxComponent()
                + vAB.getyComponent() * vAC.getyComponent();
    }

    public static double cross(Vector vAB, Vector vAC){
        return vAB.getxComponent() * vAC.getxComponent()
                - vAB.getyComponent() * vAC.getyComponent();
    }



}
