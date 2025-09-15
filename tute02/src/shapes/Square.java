package shapes;

public class Square extends Rectangle {
    private int length;

    public Square(String color) {
        super(color);
        length = 1;
        System.out.println("Inside Square constructor with one argument");
    }

    public Square(String color, int length) {
        this(color);
        this.length = length;
        System.out.println("Inside Square constructor with three arguments");
    }

    public int getArea() {
        return length * length;
    }
}
