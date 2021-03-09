package shape;

import utils.Point;

import java.awt.*;

public abstract class Shape {

    private String name = "Shape";
    private Color frameColor = new Color(0,0,0);
    private int frameWidth = 5;
    private Color fillColor = new Color(255,255,255);

    public Shape() {
    }

    public Shape(int frameWidth, Color frameColor) {
        this.frameWidth = frameWidth;
        this.frameColor = frameColor;
    }

    public Shape(int frameWidth, Color frameColor, Color fillColor) {
        this.frameWidth = frameWidth;
        this.frameColor = frameColor;
        this.fillColor = fillColor;
    }


    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Color getFrameColor() { return frameColor; }

    public void setFrameColor(Color frameColor) { this.frameColor = frameColor; }

    public int getFrameWidth() { return frameWidth; }

    public void setFrameWidth(int frameWidth) { this.frameWidth = frameWidth; }

    public Color getFillColor() { return fillColor; }

    public void setFillColor(Color fillColor) { this.fillColor = fillColor; }

    public abstract void draw(Graphics graphics);

    public abstract Point location();

    public abstract void move(Point point);

}
