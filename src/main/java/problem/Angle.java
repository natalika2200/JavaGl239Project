package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Random;

public class Angle {
    Vector A;
    Vector B;
    Vector C;
    Vector o1;
    Vector o2;

    public Angle(Vector a, Vector b, Vector c) {
        A = a;
        Vector k1 = b.minus(a);
        Vector k2 = c.minus(a);
        o1 = k1.norm().mult(100);
        o2 = k2.norm().mult(399);

        B = A.plus(o1);
        C = A.plus(o2);
    }

    public static Angle getRandomAngle() {
        Random random = new Random();
        return new Angle(
                new Vector(random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1),
                new Vector(random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1),
                new Vector(random.nextDouble() * 2 - 1, random.nextDouble() * 2 - 1)
        );
    }

//    public static Circle getRandomCircle() {
//        Random random = new Random();
//        return new Circle(
//                random.nextDouble() * 2 - 1,
//                random.nextDouble() * 2 - 1,
//                random.nextDouble() * 0.3
//        );
//    }

    public void render(GL2 gl) {

        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(A.x, A.y);
        gl.glVertex2d(B.x, B.y);

        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(A.x, A.y);
        gl.glVertex2d(C.y, C.y);
        gl.glEnd();
    }
}

//public class Angle {
//    double x1; double y1; double x2; double y2; float width;
//    public Angle (double x1, double y1, double x2, double y2, float width)
//    {
//        this.x1=x1;
//        this.y1=y1;
//        this.x2=x2;
//        this.y2=y2;
//        this.width=width;
//    }
//
//    public void render(GL2 gl) {
//        gl.glLineWidth(width);
//        gl.glBegin(GL.GL_LINES);
//        gl.glVertex2d(x1, y1);
//        gl.glVertex2d(x2, y2);
//        gl.glEnd();
//    }
//}
