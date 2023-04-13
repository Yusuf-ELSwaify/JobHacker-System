package job_hacker.tasks;

import job_hacker.tasks.models.Rectangle;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 40);
        System.out.println(r1);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        System.out.println(r2);
    }
}