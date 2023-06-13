package job_hacker.tasks;

import job_hacker.tasks.models.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three sides of the triangle:");

        double one = input.nextDouble();
        double two = input.nextDouble();
        double three = input.nextDouble();

        Triangle triangle = new Triangle(one, two, three);

        System.out.print("What color is the triangle?");

        String color = input.next();

        System.out.print("Is the triangle filled? (Enter Yes or No):");

        String fill = input.next();

        triangle.setColor(color);


        triangle.setFilled(fill.toLowerCase().startsWith("y"));

        System.out.println(triangle.toString() + " it's area is " + triangle.getArea()
                + " square units, " + "\nThe perimeter is " + triangle.getPerimeter());

        System.out.println("The triangle color is " + triangle.getColor());
        if (triangle.isFilled())
            System.out.println("triangle is filled");
        else
            System.out.println("triangle is not filled");
        input.close();
    }
}