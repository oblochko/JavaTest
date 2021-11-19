package Vector3D;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

public class P3 {
    public static final double PRECISION = 0.000001;
    public static final double HASH_PRECISION_DISCRETIZATION = 4 * PRECISION;
    public final double x,y;

    protected P3(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public static P3 of(double x, double y) {
        return new P3(x, y);
    }

    public double angleBetween(P3 vector) {
        final double y = this.x * vector.y - this.y * vector.x;
        final double x = this.x * vector.x + this.y * vector.y;
        return Math.atan2(y, x);
    }

    public double angleBetween(P3 a, P3 b) {

        final double ax = a.x - this.x;
        final double ay = a.y - this.y;
        final double bx = b.x - this.x;
        final double by = b.y - this.y;

        final double y = ax * by - ay * bx;
        final double x = ax * bx + ay * by;

        return Math.atan2(y, x);
    }
    public double angle() {
        return Math.atan2(y, x);

    }

    public P3 rotateMinus90() {
        return P3.of (y, -x);
    }

    public P3 subtract(P3 point) {
        return new P3(x - point.x, y - point.y);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }
    public double lengthSquared() {
        return x * x + y * y;
    }

    public P3 rotate(double angle) {
        return rotate(Math.sin(angle), Math.cos(angle));
    }

    public P3 rotate(double sin, double cos) {
        return P3.of(x * cos - y * sin, x * sin + y * cos);
    }

    public P3 div(double denom ) {
        return P3.of(x/denom, y/denom);
    }

    public P3 add(P3 center) {
        return P3.of(x + center.x, y + center.y);
    }

    /**
     * Scalar multiplication
     */
    public double multiply(P2 vector) {
        return (x * vector.x + y * vector.y);
    }

    public P3 multiply(double scale) {
        return P3.of(x * scale, y * scale);
    }
    public P3 multiply(double scalex, double scaley) {
        return P3.of(x * scalex, y * scaley);
    }

    public static Comparator<P3> comparing(ToDoubleFunction<P3> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<P3> & Serializable)
                (c1, c2) -> {
                    double x = keyExtractor.applyAsDouble(c1)/ HASH_PRECISION_DISCRETIZATION;
                    double y = keyExtractor.applyAsDouble(c2)/ HASH_PRECISION_DISCRETIZATION;
                    return Integer.compare((int)x, (int)y);
                };
    }


    public boolean equalsWithPrecision(P3 p) {
        return Math.abs(p.x - x) < PRECISION && Math.abs(p.y -y) < PRECISION;
    }

    public static Comparator<P3> comparator(ToDoubleFunction<P3> keyExtractor) {
        return (o1, o2) -> {
            double v1 = keyExtractor.applyAsDouble(o1);
            double v2 = keyExtractor.applyAsDouble(o2);
            return Integer.compare((int) Math.signum(v1-v2), 0);
        };
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof P3)) return false;
        P3 p3 = (P3) o;
        return this.equalsWithPrecision(p3);
    }

    @Override
    public int hashCode() {
        return Objects.hash((long) (x/ PRECISION), (long) (y/ PRECISION));
    }

}