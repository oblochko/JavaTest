package tets.bentley_ottmann;


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public TreeSet<Point> Q;

    public TreeMap<Point, List<Segment>> U;

    public TreeMap<Point, List<Segment>> T;

    public void ranSet() {
        Q = new TreeSet<>((o1, o2) -> {
            if(o1.getY() == o2.getY()){
                if(o1.getX() < o2.getX()) {
                    return 1;
                } else {
                    return -1;
                }
            }

            if(o1.getY() > o2.getY()) {
                return 1;
            } else {
                return -1;
            }
        });

        Q.add(new Point(3, 6));
        Q.add(new Point(4, 4));
        Q.add(new Point(1, 7));
        Q.add(new Point(3, 7));
        Q.add(new Point(6, 10));

        Q.stream().forEach(System.out::println);

    }

    public void ranT() {
        T = new TreeMap<>((o1, o2) -> {
            if(o1.getX() > o2.getX()) return 1;
            if(o1.getX() < o2.getX()) return -1;
            return 0;
        });

        addTreeMap(T, new Point(1.43, 1.99), new Segment(new Point(2.05, 1), new Point(0.88, 2.84)));
        addTreeMap(T, new Point(4, 2), new Segment(new Point(3.05, 3.22), new Point(4, 2)));
        addTreeMap(T, new Point(4, 2), new Segment(new Point(5.16, 3.64), new Point(4, 2)));
        addTreeMap(T, new Point(6.1, 1.99), new Segment(new Point(6.75, 3.13), new Point(5.46, 0.86)));

        //T.stream().forEach(System.out::println);
        T.navigableKeySet().stream().forEach(o -> T.get(o).stream().forEach(System.out::println));

        System.out.println("");

        Point pointL = T.lowerKey(new Point(4, 2));
        Point pointU = T.higherKey(new Point(4, 2));
        System.out.println(pointL);
        System.out.println(pointU);

        List<Segment> list = new ArrayList<>();
        list.add(new Segment(new Point(3.05, 3.22), new Point(4, 2)));
        list.add(new Segment(new Point(5.16, 3.64), new Point(4, 2)));

        System.out.println("");

        deleteTreeMap(T, new Point(4, 2), list);

        T.navigableKeySet().stream().forEach(o -> T.get(o).stream().forEach(System.out::println));

    }

    public void ranMap(List<Segment> list) {
        U = new TreeMap<>((o1, o2) -> {
            if(o1.getY() == o2.getY()){
                if(o1.getX() < o2.getX()) {
                    return 1;
                } else {
                    return -1;
                }
            }

            if(o1.getY() > o2.getY()) {
                return 1;
            } else {
                return -1;
            }
        });

        for(int i = 0; i < 5; i ++) {

        }

    }

    public void addTreeMap(TreeMap<Point, List<Segment>> map, Point point, Segment segment) {
        if(!map.containsKey(point)) {
            map.put(point, new ArrayList<Segment>());
            map.get(point).add(segment);
        } else {
            map.get(point).add(segment);
        }
    }

    public void deleteTreeMap(TreeMap<Point, List<Segment>> map, Point point, List<Segment> list) {
        if(!map.containsKey(point))
            return;
        List<Segment> lSegment = map.get(point);

        for(Segment s : list) {
            lSegment.remove(lSegment.stream().filter(o -> o.equals(s)).findFirst().get());
        }
    }



    public void ranIntersec(){

        System.out.println("Не пересекаются: ");
        pointIntersec(new Point(6.5, 4.7), new Point(20, 10),  new Point(7.9, 9), new Point(14.8, 11.8));

        System.out.println("Пересекаются ~(4.3, 3.95): ");
        pointIntersec(new Point(3, 4.8), new Point(5.76, 3),  new Point(6.5, 5.5), new Point(2.56, 2.75));

        System.out.println("Пересекаются (частный случай: середина и конец ~(4, 2): ");
        pointIntersec(new Point(2, 2), new Point(6, 2),  new Point(4, 4), new Point(4, 2));

        System.out.println("Пересекаются (частный случай: конец и конец ~(3.52, 1.24): ");
        pointIntersec(new Point(1.53, 3.15), new Point(3.52, 1.24),  new Point(4.27, 3.36), new Point(3.52, 1.24));

        //System.out.println("Пересекаются: ");
        //pointIntersec(new Point(6.5, 4.7), new Point(20, 10),  new Point(7.9, 9), new Point(14.8, 11.8));

    }

    public void pointIntersec(Point a1, Point a2, Point b1, Point b2) {
        Segment s1 = new Segment(a1, a2);

        Segment s2 = new Segment(b1, b2);
        //System.out.println("Не пересекаются: ");
        if(GeometryOperation.checkSegmentIntersection(s1, s2)) {
            System.out.println("Intersection");
            Point point = GeometryOperation.pointOfIntersection(s1, s2);
            System.out.println(point);
        }
        else
            System.out.println("Not intersection");
    }

    public static void main(String[] args){
        Main main = new Main();
        main.ranT();
        //double theta = 180.0 / Math.PI * Math.atan2(12 - 10, 2 - 2);
        double theta = GeometryOperation.getAngle2(new Point(3, 2), new Point(3, 1), new Point(4, 1) );
        theta = GeometryOperation.getAngle2(new Point(1, 1.5), new Point(1.5, 2) , new Point(1.5, 1.5) );
        Comparator<Segment> comparator = (o1, o2) -> {
            if(o1.equals(o2)) return 0;
            if(o1.getSecond().getX() == o2.getSecond().getX())
                if(o1.getSecond().getY() > o2.getSecond().getY()) return 1;
                else return -1;
            if(o1.getSecond().getX() > o2.getSecond().getX()) return 1;
            if(o1.getSecond().getX() < o2.getSecond().getX()) return -1;
            return 0;
        };

        TreeSet<Segment> treeSet = new TreeSet<>();
        /*treeSet.add(newSegment(5, 5, 8, 2)); //CD
        treeSet.add(newSegment(6, 5, 6, 3)); //AB
        treeSet.add(newSegment(7, 5, 4, 2)); //EF*/
        treeSet.add(newSegment(7, 4, 5, 2)); //AB
        treeSet.add(newSegment(7, 4, 9, 2)); //AD
        treeSet.add(newSegment(7, 4, 7, 3)); //AC

        for(Segment segment : treeSet) {
            System.out.println(segment);
        }
        System.out.println();

        //ArrayList<Segment> list = (ArrayList<Segment>) treeSet.stream().sorted(comparator).collect(Collectors.toList());
        TreeSet<Segment> treeSet1 = new TreeSet<>(comparator);
        treeSet1.addAll(treeSet);
        System.out.println(treeSet.stream().min(comparator).get());
        for(Segment segment : treeSet1) {
            System.out.println(segment);
        }
        System.out.println();
        treeSet.clear();

        treeSet.add(newSegment(5, 5, 8, 2)); //CD
        treeSet.add(newSegment(6, 5, 6, 3)); //AB
        treeSet.add(newSegment(7, 5, 4, 2)); //EF

        for(Segment segment : treeSet) {
            System.out.println(segment);
        }
        System.out.println();




        System.out.println(theta);
    }

    public static Segment newSegment(double p1, double p2, double p3, double p4) {
        return new Segment(new Point(p1, p2), new Point(p3, p4));
    }

    public Point randomPoint() {
        return new Point(randomInteger(0, 10), randomInteger(0, 10));
    }

    public Segment randomSegment() {
        return new Segment(randomPoint(), randomPoint());
    }

    public double randomInteger(int max, int min) {
        return (Math.random() * ((max - min) + 1)) + min;
    }
}
