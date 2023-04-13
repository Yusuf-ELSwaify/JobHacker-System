package job_hacker.tasks.models;

public class Location {
    private int row;
    private int column;
    private double maxValue;

    private Location() {
    }

    public static Location locateLargest(double[][] a){
        Location location = new Location();
        location.maxValue = Double.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > location.maxValue)
                {
                    location.row = i;
                    location.column = j;
                    location.maxValue = a[i][j];
                }
            }
        }
        return location;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("The location");
        sb.append(" of the largest element is ").append(String.format("%.2f", maxValue));
        sb.append(" at (").append(row);
        sb.append(", ").append(column);
        sb.append(')');
        return sb.toString();
    }
}
