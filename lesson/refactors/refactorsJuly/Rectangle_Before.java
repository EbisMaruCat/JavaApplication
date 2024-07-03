package lesson.refactors.refactorsJuly;

public class Rectangle_Before {
    private double width;
    private double height;
    private double x;
    private double y;

    public Rectangle_Before(double width, double height, double x, double y){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }

    public static void main(String[] args){
        Rectangle_Before recB = new Rectangle_Before(3,5,0,0);
        Point p = new Point(2,3);

        if(p.x >= recB.x &&
           p.x <= recB.x + recB.width &&
           p.y >= recB.y &&
           p.y >= recB.y + recB.height
        ){
            System.out.println("Inside");
        }else{
            System.out.println("Outside");
        }

    }
}

class Point{
    public double x;
    public double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
}
