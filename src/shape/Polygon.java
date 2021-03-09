package shape;

import utils.Point;

import java.awt.*;
import java.util.List;

public class Polygon extends Shape {

    private List<Point> points;

    public Polygon() {

    }

    public Polygon(List<Point> points,int frameWidth, Color frameColor, Color fillColor) {
        super(frameWidth, frameColor, fillColor);
        this.points = points;
    }

    public Polygon(int frameWidth, Color frameColor, Color fillColor) {
        super(frameWidth, frameColor, fillColor);
    }

    public List<Point> getPoints() { return points; }

    public void setPoints(List<Point> points) { this.points = points; }

    @Override
    public void draw(Graphics graphics) {
        //drawPolygon(int[] xPoints, int[] yPoints, int nPoints)

        int[] xPoints = new int[points.size()];
        int[] yPoints = new int[points.size()];
        for(int  i=0; i<points.size(); i++){
            xPoints[i] = points.get(i).x;
            yPoints[i] = points.get(i).y;
        }

        graphics.setColor(super.getFrameColor());
        graphics.drawPolygon(xPoints, yPoints, points.size());

        graphics.setColor(super.getFillColor());
        graphics.fillPolygon(xPoints, yPoints, points.size());
    }


    @Override
    public Point location() {
        Point center = new Point();
        int sumX = 0;
        int sumY = 0;
        for (Point point:points){
            sumX += point.x;
            sumY += point.y;
        }

        center.x = sumX / points.size();
        center.y = sumY / points.size();
        return  center;
    }

    @Override
    public void move(Point point) {

    }

}
