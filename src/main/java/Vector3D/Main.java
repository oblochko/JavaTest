package Vector3D;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import glm_.quat.Quat;
import glm_.vec2.Vec2;
import glm_.vec3.Vec3;
import glm_.mat4x4.Mat4;
import glm_.GlmKt;
import glm_.glm;


public class Main {
    final static glm _glm= glm.INSTANCE;;

    public static void main(String[] args){
        Vector3d AB = new Vector3d(2, 3, 1);
        Vector3d AC = new Vector3d(1, 3, 1);

        System.out.println(AB.angle(AC));

        Point3d A = new Point3d(2, 3, 1);

        System.out.println("------");
        //testP2();

        Vec3 vecA = new Vec3(1.0, 2.0, 3.0);
        Vec3 vecAR = new Vec3();
        _glm.normalize(vecA, vecAR);
        Vec3 vecB = new Vec3(5.0, 4.0, 2.0);
        Vec3 vecBR = new Vec3();
        _glm.normalize(vecB, vecBR);



        float angle2 = _glm.angle(vecAR, vecBR);

        Quat quat = _glm.angleAxis((float) 2.3, new Vec3(2.0, 2.0, 3.0));
        System.out.println(quat);
        System.out.println(" " + angle2);
    }

    public static void testP2() {
        P2 AB = new P2(3, 4);
        P2 AC = new P2(7, 3);
        P2 AD = new P2(4, 6);
        Vector3d vec = new Vector3d(3, 4, 0);

        System.out.println(AB.angleBetween(AC));
        System.out.println(AB.angleBetween(AC, AD));
        System.out.println(AB.angle());
        System.out.println(angle(vec));
        System.out.println(AB.rotate(30));

    }

    public static double angle(Vector3d v1) {
        double vDot = v1.dot(v1) / (v1.length());
        if (vDot < -1.0D) {
            vDot = -1.0D;
        }

        if (vDot > 1.0D) {
            vDot = 1.0D;
        }

        return Math.acos(vDot);
    }
}
