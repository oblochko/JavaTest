package Vector3D;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.ToDoubleFunction;

@Data
public class P2 {
    public final double x,y,z;

    protected P2(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public static P2 of(double x, double y, double z) {
        return new P2(x, y, z);
    }

    public static P2 of(OdGePoint3d p) {
        return of( p.getX(),  p.getY(), p.getZ());
    }

    public double angleBetween(P2 vector) {
        double vDot = this.dot(vector) / (this.length() * vector.length());
        if (vDot < -1.0D) {
            vDot = -1.0D;
        }

        if (vDot > 1.0D) {
            vDot = 1.0D;
        }

        return Math.acos(vDot);
        /*final double y = this.x * vector.y - this.y * vector.x;
        final double x = this.x * vector.x + this.y * vector.y;
        return Math.atan2(y, x);*/
    }

    public double angleBetween(P2 a, P2 b) {

        final double ax = a.x - this.x;
        final double ay = a.y - this.y;
        final double bx = b.x - this.x;
        final double by = b.y - this.y;
        P2 ar = new P2(a.x - this.x, a.y - this.y, a.z - this.z);
        P2 br = new P2(b.x - this.x, b.y - this.y, b.z - this.z);
        //final double y = ax * by - ay * bx;
        //final double x = ax * bx + ay * by;
        // return Math.atan2(y, x);

        double vDot = dot(ar, br) / (ar.length() * br.length());
        if (vDot < -1.0D) {
            vDot = -1.0D;
        }

        if (vDot > 1.0D) {
            vDot = 1.0D;
        }

        return Math.acos(vDot);

    }

    public double angle() {
        return angleBetween(new P2(1.0, 1.0, 1.0));
    }

    public final double dot(P2 a) {
        return this.x * a.x + this.y * a.y + this.z * a.z;
    }

    public final double dot(P2 a, P2 b) {
        return a.x * b.x + a.y * b.y + a.z * b.z;
    }

    public P2 rotateMinus90() {
        return P2.of (y, -x, z);
    }

    public P2 subtract(P2 point) {
        return new P2(x - point.x, y - point.y, z - point.z);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }
    public double lengthSquared() {
        return x * x + y * y + z * z;
    }

    public P2 rotate(double angle) {
        return rotate(Math.sin(angle), Math.cos(angle));
    }

    public P2 rotate(double sin, double cos) {
        return P2.of(x * cos - y * sin, x * sin + y * cos, z);
    }

    public P2 rotateX(double angle) {
        return P2.of(x,y * Math.cos(angle) + z * Math.sin(angle), -y * Math.sin(angle) + z * Math.cos(angle));
    }

    public P2 rotateY(double angle) {
        return P2.of(x * Math.cos(angle) + z * Math.sin(angle),y, -y * Math.sin(angle) + z * Math.cos(angle));
    }

    public P2 rotateZ(double angle) {
        return P2.of(x * Math.cos(angle) + y * Math.sin(angle),-x * Math.sin(angle) + y * Math.cos(angle), z);
    }

    public P2 div(double denom ) {
        return P2.of(x/denom, y/denom, z/denom);
    }

    public P2 add(P2 center) {
        return P2.of(x + center.x, y + center.y, z + center.z);
    }

    /**
     * Scalar multiplication
     */
    public double multiply(P2 vector) {
        return (x * vector.x + y * vector.y + z * vector.z);
    }

    public P2 multiply(double scale) {
        return P2.of(x * scale, y * scale, z * scale);
    }

    public P2 multiply(double scalex, double scaley, double scalez) {
        return P2.of(x * scalex, y * scaley, z * scalez);
    }

    public static Comparator<P2> comparing(ToDoubleFunction<P2> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<P2> & Serializable)
                (c1, c2) -> {
                    double x = keyExtractor.applyAsDouble(c1)/ HASH_PRECISION_DISCRETIZATION;
                    double y = keyExtractor.applyAsDouble(c2)/ HASH_PRECISION_DISCRETIZATION;
                    return Integer.compare((int)x, (int)y);
                };
    }


    public boolean equalsWithPrecision(P2 p) {
        return Math.abs(p.x - x) < PRECISION && Math.abs(p.y -y) < PRECISION;
    }

    public static Comparator<P2> comparator(ToDoubleFunction<P2> keyExtractor) {
        return (o1, o2) -> {
            double v1 = keyExtractor.applyAsDouble(o1);
            double v2 = keyExtractor.applyAsDouble(o2);
            return Integer.compare((int) Math.signum(v1-v2), 0);
        };
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof P2)) return false;
        P2 p2 = (P2) o;
        return this.equalsWithPrecision(p2);
    }

    @Override
    public int hashCode() {
        return Objects.hash((long) (x/ PRECISION), (long) (y/ PRECISION));
    }
}
