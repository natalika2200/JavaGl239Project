package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;
import java.util.Random;

public class Circle {

    double centerx;
    double centery;
    double rad;

    public Circle(double centerx, double centery, double rad) {
        this.centerx = centerx;
        this.centery = centery;
        this.rad = rad;
    }

    public static Circle getRandomCircle() {
        Random random = new Random();
        return new Circle(
                random.nextDouble() * 2 - 1,
                random.nextDouble() * 2 - 1,
                random.nextDouble() * 0.3
        );
    }

    public void render(GL2 gl) {
        gl.glBegin(GL.GL_LINE_STRIP);
        for (int i = 0; i <= 589; i++) {
            double angle = 2 * Math.PI / 40 * i;
            double x = rad * Math.cos(angle);
            double y = rad * Math.sin(angle);
            gl.glVertex2d(x + centerx, y + centery);

        }
        gl.glEnd();
    }
}
