class Circle extends Shape {
    private Point center;
    private int radius;
    public Circle(Point p, int r) {
        center = p;
        radius = r;
    }
    public Circle(int x, int y, int r) {
        center = new Point(x, y);
        radius = r;
    }
    @Override
    public double getArea() {
        return Math.abs(3.14 * radius * radius);
    }
    @Override
    public double getPerimeter() {
        return Math.abs(3.14*2*radius);
    }
    @Override
    public String toString() {
        return "Circle:\n"+"center: "+center+"\nradius: "+radius;
    }
}
