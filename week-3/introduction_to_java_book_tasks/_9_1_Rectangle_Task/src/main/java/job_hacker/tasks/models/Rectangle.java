package job_hacker.tasks.models;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getPerimeter(){
        return (width + height) * 2;
    }
    public double getArea(){
        return width * height;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Rectangle{");
        sb.append("width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", perimeter=").append(getPerimeter());
        sb.append(", area=").append(getArea());
        sb.append('}');
        return sb.toString();
    }
}
