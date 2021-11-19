package tets.bentley_ottmann;

import java.util.*;

public class BentleyOttmann {
    Set<Point> Q = new HashSet<>();
    Set<Segment> T = new HashSet<>();

    Map<Point, List<Segment>> U = new HashMap<>();
    Map<Point, List<Segment>> L = new HashMap<>();
    Map<Point, List<Segment>> C = new HashMap<>();

    public BentleyOttmann() {

    }

    public void findInterSections(List<Segment> list){
        init(list);
        while(!Q.isEmpty()){
            Point point = Q.iterator().next();
            Q.remove(point);
            handleEvent(point);
        }
    }

    public void init(List<Segment> list) {
        for(Segment segment: list) {
            if(!Q.contains(segment.getFirst())) {
                Q.add(segment.getFirst());
            }
            if(!Q.contains(segment.getSecond())) {
                Q.add(segment.getSecond());
            }

            if(!U.containsKey(segment.getFirst())) {
                U.put(segment.getFirst(), new ArrayList<Segment>());
                U.get(segment.getFirst()).add(segment);
            } else {
                U.get(segment.getFirst()).add(segment);
            }

            if(!L.containsKey(segment.getSecond())) {
                L.put(segment.getSecond(), new ArrayList<Segment>());
                L.get(segment.getSecond()).add(segment);
            } else {
                L.get(segment.getSecond()).add(segment);
            }
        }
    }

    public void handleEvent(Point point) {
        if(U.get(point).size() + L.get(point).size()
                + (C.containsKey(point) ? C.get(point).size() : 0) > 1) {
            System.out.println("Точка пересечения: " + point.getX() + " : " + point.getY());
        }

        T.removeAll(L.get(point));
        T.removeAll(C.get(point));

        T.addAll((U.get(point)));
        T.addAll((C.get(point)));

        if(U.get(point).size() + C.get(point).size() == 0) {
            Segment bLeft;
            Segment bRight;
            //findNewEvent(bLeft, bRight, point);
        }
    }

    public void findNewEvent(Segment s_first, Segment s_second, Point point){
        Point inters = isIntersection(s_first, s_second);


    }

    public Point isIntersection(Segment s_first, Segment s_second) {
        return new Point();
    }

}
