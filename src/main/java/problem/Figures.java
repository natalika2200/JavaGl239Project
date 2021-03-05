package problem;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Figures {
    public static void renderPoint(GL2 gl, Vector pos, float size) {
        gl.glPointSize(size);
        gl.glBegin(GL.GL_POINTS);

        gl.glVertex2d(pos.x, pos.y);
        gl.glEnd();
    }

    public static void renderPoint(GL2 gl, double x, double y, int i) {
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glEnd();
    }

    public static void renderLine(GL2 gl, double x1, double y1, double x2, double y2, float width) {
        gl.glLineWidth(width);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x2, y2);
        gl.glEnd();
    }

    public static void renderTriangle(GL2 gl, double x1, double y1, double x2, double y2, double x3, double y3, boolean filed){
        if(filed) {
            gl.glBegin(GL.GL_TRIANGLES);
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x3, y3);
            gl.glEnd();
        }else{
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x1, y1);
            gl.glEnd();
        }
    }
    public static void renderQuad(GL2 gl, double x1, double y1, double x2, double y2, double x3, double y3,double x4, double y4, boolean filed){
        if(filed) {
            gl.glBegin(GL2GL3.GL_QUADS);
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x4, y4);
            gl.glEnd();
        }else{
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glVertex2d(x1, y1);
            gl.glVertex2d(x2, y2);
            gl.glVertex2d(x3, y3);
            gl.glVertex2d(x4, x4);
            gl.glVertex2d(x1, y1);
            gl.glEnd();
        }
    }



}
