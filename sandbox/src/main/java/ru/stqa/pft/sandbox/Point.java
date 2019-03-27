package ru.stqa.pft.sandbox;

public class Point {
  public double w, x, y, z;
  
  
  public Point(double w, double x) {
    this.w = w;
    this.x = x;
    
  }
  
  public Point(double w, double x, double y, double z) {
    this.w = w;
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public double distance() {
    return Math.sqrt((this.x - this.w) * (this.x - this.w) + (this.z - this.y) * (this.z - this.y));
  }
}