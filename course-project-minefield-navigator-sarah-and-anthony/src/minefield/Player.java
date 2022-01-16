package minefield;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.Image;
import java.awt.*;

/**
 * Creates a player
 */
public class Player extends GraphicsGroup{
    public static final double BOX_WIDTH = 54; 
    public static final double BOX_HEIGHT = 59; 
    public static final double HORIZONTAL = 240; 
    public static final double VERTICAL = 230; 

    private double maxXposition, maxYposition, positionX, positionY, playerWidth; 

    GraphicsObject playerIcon;
    Rectangle playerSquare; 
    
     /**
     * Creates a new player object
     * 
     * @param startX - original starting position of player, x
     * @param startY - original starting position of player, y
     * @param playerLength - player size, length 
     * @param playerWidth - player size, width 
     * @param maxX - max x position of player, used to keep on screen
     * @param maxY - max y position of player, used to keep on screen
     */
    public Player(double startX, double startY, double playerLength, double playerWidth, double maxX, double maxY) {
        super(0, 0);
        positionX = startX;
        positionY = startY;
        maxXposition = maxX; 
        maxYposition = maxY; 

        this.playerIcon = new Image("man-emoji.png");
        playerIcon.setPosition(startX - HORIZONTAL - BOX_WIDTH,startY - VERTICAL - BOX_HEIGHT);
        playerIcon.setScale(0.07,0.07);

        playerSquare = new Rectangle(startX, startY, playerLength, playerWidth);
        playerSquare.setFillColor(Color.WHITE);
    }

    /**
    * Creates a player icon using an imported man image
    */
    public GraphicsObject getPlayerIcon() {
        return this.playerIcon;
    }

    /**
    * Creates a player square behind the player icon
    */
    public Rectangle getPlayerSquare() {
        return this.playerSquare; 
    }

    /**
     * Tests if player is in bounds of canvas
     * @return true if player is in bound on canvas' left side
     */
    public boolean isInBoundsNear() { 
        if (positionX <= 0) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * Test if player is in bounds of canvas
     * @return true if player is in bound on canvas' right side
     */
    public boolean isInBoundsFar() {
        if (positionX + playerWidth > maxXposition - 118) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * Test if player is in bounds of canvas
     * @return true if player is in bound on canvas' top 
     */
    public boolean isInBoundsUp() {
        if (positionY <= 0) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * Test if player is in bounds of canvas
     * @return true if player is in bound on canvas' bottom 
     */
    public boolean isInBoundsDown() {
        if (positionY + playerWidth > maxYposition - 118) {
            return false;
        } 
        else {
            return true;
        }
    }

    /**
     * Updates the player's position to the left
     * @return true if position can be updated left
     */
    public boolean updatePositionLeft() {
        double newPositionX = positionX - BOX_WIDTH;
        if (isInBoundsNear()) {
            positionX = newPositionX;
            this.playerSquare.setPosition(positionX, positionY);
            this.playerIcon.setPosition(positionX - HORIZONTAL - BOX_WIDTH, positionY - VERTICAL - BOX_HEIGHT);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Updates the player's position to the right
     * @return true if position can be updated right
     */
    public boolean updatePositionRight() {
        double newPositionX = positionX + BOX_WIDTH;
        if (isInBoundsFar()) {
            positionX = newPositionX;
            this.playerSquare.setPosition(positionX, positionY);
            this.playerIcon.setPosition(positionX - HORIZONTAL - BOX_WIDTH, positionY - VERTICAL - BOX_HEIGHT);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Updates the player's position to go up
     * @return true if position can be updated to go up
     */
    public boolean updatePositionUp() {
        double newPositionY = positionY - BOX_HEIGHT; 
        if (isInBoundsUp()) {
            positionY = newPositionY;
            this.playerSquare.setPosition(positionX, positionY);
            this.playerIcon.setPosition(positionX - HORIZONTAL - BOX_WIDTH, positionY - VERTICAL - BOX_HEIGHT);

            return true;
        }
        else {
            return false; 
        }
    }

    /**
     * Updates the player's position to go down
     * @return true if position can be updated to go down
     */
    public boolean updatePositionDown() {
        double newPositionY = positionY + BOX_HEIGHT; 
        if (isInBoundsDown()) {
            positionY = newPositionY;
            this.playerSquare.setPosition(positionX, positionY);
            this.playerIcon.setPosition(positionX - HORIZONTAL - BOX_WIDTH, positionY - VERTICAL - BOX_HEIGHT);

            return true; 
        }
        else {
            return false; 
        }
    }
}


