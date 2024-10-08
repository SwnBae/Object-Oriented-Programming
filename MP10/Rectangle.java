class Rectangle extends Shape {
    private Point p1;
    private Point p2;
    public Rectangle(Point p1,Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    public Rectangle(int x1,int x2,int y1,int y2){
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
    }
    @Override
    public double getArea() {
        return Math.abs((p2.getX())- p1.getX()*(p2.getY()- p1.getY()));
    }
    @Override
    public double getPerimeter() {
        return Math.abs(2*(p2.getX()- p1.getX())+2*(p2.getY()- p1.getY()));
    }
    @Override
    public String toString() {
        return "Rectangle:\n"+"p1: "+p1+"\np2: "+p2;
    }
}
