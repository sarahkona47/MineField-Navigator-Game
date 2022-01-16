package minefield;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Image;
import edu.macalester.graphics.Rectangle;

/**
 * Constructs a mine
 */
public class Mine extends GraphicsGroup {

    GraphicsObject mineIcon; 
    Rectangle square;
    private double length;
    private double width;

    /**
     * Creates a new mine object for the MineFieldNavigator game
     * 
     * @param x - position of mine, x
     * @param y - position of mine, y
     * @param mineLength - mine size, length 
     * @param mineWidth - mine size, width 
     */
    public Mine(double x, double y, double mineLength, double mineWidth) {
        super(0, 0);
        
        this.mineIcon = new Image("mine-emoji.png");
        mineIcon.setPosition(x - 230, y - 225);
        mineIcon.setScale(0.1,0.1);

        square = new Rectangle(x, y, mineLength, mineWidth);
    }

    /**
    * Setter function for mine length
    */
    public void setLength(double length) { 
        this.length = length; 
    }

    /**
    * Setter function for mine width
    */
    public void setWidth(double width) { 
        this.width = width; 
    }

    /**
    * Creates mine icon which uses a bomb image 
    */
    public GraphicsObject getMineIcon() {
        return this.mineIcon;
    }

    /**
    * Creates square behind mine bomb image
    */
    public Rectangle getSquare() {
        return this.square; 
        
    }

}