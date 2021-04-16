package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Иванова Ивана";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Circle> circles;
    private ArrayList<Angle> angles;

    Circle resCircle;
    Angle resAngle;

    //    private ArrayList<Angle> angles;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        circles = new ArrayList<>();
//        angles = new ArrayList<>();
        angles = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x координата X точки
     * @param y координата Y точки
     */
    public void addCircle(double x, double y, double rad) {
        circles.add(new Circle(x, y, rad));
    }


    public void addAngle(double x1, double y1, double x2, double y2, double x3, double y3) {
        angles.add(new Angle(new Vector(x1, y1), new Vector(x2, y2), new Vector(x3, y3)));
    }

    /**
     * Решить задачу
     */
    public void solve() {
        int max = 0;
        for (int i = -100; i <= 100; i++) {
            for (int j = -100; j <= 100; j++) {
                points.add(new Point(0.01 * i, 0.01 * j));
            }
        }
        for (Circle c : circles) {
            for (Angle a : angles) {
                if (c.Square(a, points) > max) {
                    max = c.Square(a, points);
                }
            }
        }
        for (Circle c : circles) {
            for (Angle a : angles) {
                if (c.Square(a, points) == max) {
                    resCircle = c;
                    resAngle = a;
                    for (Point p : points) {
                        if (c.IsInside(p) && a.IsInside(p)) {
                            p.isSolution = true;
                        }
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        circles.clear();
        angles.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            int circleCnt = sc.nextInt();
            for (int i = 0; i < circleCnt; i++) {
                circles.add(new Circle(
                        sc.nextDouble(), sc.nextDouble(), sc.nextDouble()
                ));
            }
            int angleCnt = sc.nextInt();
            for (int i = 0; i < angleCnt; i++) {
                angles.add(new Angle(
                        new Vector(sc.nextDouble(), sc.nextDouble()),
                        new Vector(sc.nextDouble(), sc.nextDouble()),
                        new Vector(sc.nextDouble(), sc.nextDouble())
                ));
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            out.println(circles.size());
            for (Circle circle : circles) {
                out.printf("%.2f %.2f %.2f\n", circle.centerx, circle.centery, circle.rad);
            }
            out.println(angles.size());
            for (Angle angle : angles) {
                out.printf("%.2f %.2f %.2f %.2f %.2f %.2f\n", angle.A.x, angle.A.y, angle.B.x, angle.B.y, angle.C.x, angle.C.y);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomCircle(int n) {
        for (int i = 0; i < n; i++) {
            Circle c = Circle.getRandomCircle();
            circles.add(c);
        }
    }

    public void addRandomAngles(int n) {
        for (int i = 0; i < n; i++) {
            Angle a = Angle.getRandomAngle();
            angles.add(a);
        }
    }
    //    public void addRandomAngles(int n) {
//        for (int i = 0; i < n; i++) {
//            Angle a = Angle.getRandomAngle();
//            circles.add(a);
//        }
//    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        circles.clear();
//        angles.clear();
        angles.clear();
        resCircle = null;
        resAngle = null;
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
        gl.glColor3d(1,0,0);
        for (Circle c : circles)
            c.render(gl);
        for (Angle a : angles)
            a.render(gl);
        gl.glColor3d(1,1,0);
        for (Point p : points) {
            if (p.isSolution) {
                p.render(gl);
            }
        }
        gl.glColor3d(0,0,1);
        if (resAngle != null) {
            resAngle.render(gl);
            resCircle.render(gl);
        }
        //        public void render(GL2 gl) {
//            for (Angles a : angles)
//                a.render(gl);

//        for (Point point : points) {
//            point.render(gl);
//        }
//
//        gl.glColor3d(0, 1, 1);
//        gl.glPointSize(5);
//        Figures.renderPoint(gl, 0.5, 0.5, 3);
//        gl.glColor3d(1, 0, 1);
//        gl.glPointSize(10);
//        Figures.renderPoint(gl, -0.5, 0.5, 5);
//        gl.glColor3d(0, 1, 0);
//        gl.glPointSize(10);
//        Figures.renderPoint(gl, 0.5, -0.5, 4);
//
//        gl.glColor3d(1, 1, 1);
//
//        Figures.renderLine(gl, 0.5, 0.5, 3, 1, 3);
//
//        gl.glColor3d(0, 0, 1);
//        Figures.renderTriangle(gl, 0.5, 0.5, -0.5, 0.5, 0.5, -0.5, true);
//
//        gl.glColor3d(0, 1, 1);
//        Figures.renderTriangle(gl, 0.5, 0.5, -0.5, 0.5, 0.5, -0.5, false);
//
//        gl.glColor3d(0, 1, 1);
//        Figures.renderQuad(gl,0.5, 0.5, -0.5, 0.5, 0.5, -0.5, 0.1, 0.2, true );
//        gl.glColor3d(0, 1, 1);
//        Circle circle = new Circle(0.1, 0.2, 0.1);
//        circle.render(gl);
//
//        gl.glColor3d(0.6, 0.3, 0.1);
//        circle = new Circle(0.5, 0.2, 0.1);
//        circle.render(gl);
//
//        gl.glColor3d(1, 0, 1);
//        Angle line = new Angle(new Vector(0.5, 0.5), new Vector(3, 1), new Vector(3, 1));
//        line.render(gl);
//


    }
}