package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Point p1 = new Point (2.0,5.0);
        Point p2 = new Point (5.0,9.0);
    
        System.out.println(distance(p1,p2));
    }
    
    public static double distance (Point p1, Point p2)
    {
        return (Math.sqrt(((p2.x - p1.x)*(p2.x - p1.x))+((p2.y-p2.x)*(p2.y-p2.x))));
        
    }
}
