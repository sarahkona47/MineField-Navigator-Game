package minefield;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Line;
import edu.macalester.graphics.events.Key;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

/**
 * The game of MineField Navigator
 * 
 * @author ANTHONY PALMA, SARAH CHOI
 * Acknowlegements: Preceptor Nam and Izzy, Stackoverflow.com
 */
public class MineFieldNavigator {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 650;

    private CanvasWindow canvas;
    private Player player; 
    private List<Mine> mines;
    private int lives = 3; 
    private int round = 1; 
    GraphicsText livesLabel, roundLabel;
    
    /**
     * Creates new MineFieldNavigator game 
     */
    public MineFieldNavigator() {
        canvas = new CanvasWindow("MineField Navigator", CANVAS_WIDTH, CANVAS_HEIGHT); 
        mines = new ArrayList<>();
    }

    /**
     * Draws a grid on the canvas 
     */
    public void drawGrid() {
        int width = CANVAS_WIDTH;
        int height = CANVAS_HEIGHT;
        int yStart = 0;
        int xStart = 0; 
    
        for(int i = 1; i <= 11; i++) { //this creates a grid from looped intersecting lines 
            Line line = new Line(xStart, 0, xStart, height - 60); 
            Line line2 = new Line(0, yStart, width - 60, yStart); 
            yStart = i*((height - 60)/10);
            xStart = i*((width - 60)/10);
            canvas.add(line2);
            canvas.add(line);
            canvas.draw();
        }
    }

    /**
     * Creates a list of mine objects, with the number determined by round * 5
     * and the location determined by a random number generator
     */
    public void addMine() {
        for (int i = 1; i <= round * 5 ; i++){ // mines start at 5 and increase by 5 each round
            Random rand = new Random();
            Mine mine;
            int randInt = rand.nextInt(100) + 1;
            if ((randInt > 0) && (randInt <= 10)) { // if rand int is in row 1, 
                mine = new Mine(54 * (randInt - 1),0,54,59); // set mine to have respective position 1-10, row 1
            }
            else if ((randInt > 10) && (randInt <= 20)) { // if rand int is in row 2, 
                mine = new Mine(54 * (randInt - 11),59,54,59); // set mine to have respective position 1-10, row 2
            }
             else if ((randInt > 20) && (randInt <= 30)) { // ...
                mine = new Mine(54 * (randInt - 21),118,54,59); // ...
            }
            else if ((randInt > 30) && (randInt <= 40)) {
                mine = new Mine(54 * (randInt - 31),177,54,59);
            }
            else if ((randInt > 40) && (randInt <= 50)) {
                mine = new Mine(54 * (randInt - 41),236,54,59);
            }
            else if ((randInt > 50) && (randInt <= 60)) {
                mine = new Mine(54 * (randInt - 51),295,54,59);
            }
            else if ((randInt > 60) && (randInt <= 70)) {
                mine = new Mine(54 * (randInt - 61),354,54,59);
            }
            else if ((randInt > 70) && (randInt <= 80)) {
                mine = new Mine(54 * (randInt - 71),413,54,59);
            }
            else if ((randInt > 80) && (randInt <= 90)) {
                mine = new Mine(54 * (randInt - 81),472,54,59);
            }
            else {
                mine = new Mine(54 * (randInt - 91),531,54,59);
            } 
            canvas.add(mine);
            canvas.add(mine.getSquare());
            canvas.add(mine.getMineIcon());
            mines.add(mine); 
        }
    }

    /**
     * Randomly places the player at the start of each round 
     */
    public void addPlayer() {
        Random rand = new Random();
        int randInt = rand.nextInt(10) + 1;
        if (randInt == 1) { // if rand int is 1, set player position to below bottom row, position 1
            player = new Player(0,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT); 
        }
        else if (randInt == 2) { // if rand int is 2, set player position to below bottom row, position 2
            player = new Player(54 * 1,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 3) { // ... 
            player = new Player(54 * 2,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 4) {
            player = new Player(54 * 3,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 5) {
            player = new Player(54 * 4,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 6) {
            player = new Player(54 * 5,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 7) {
            player = new Player(54 * 6,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 8) {
            player = new Player(54 * 7,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 9) {
            player = new Player(54 * 8,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        else if (randInt == 10) {
            player = new Player(54 * 9,590,54,59, CANVAS_WIDTH, CANVAS_HEIGHT);
        }
        canvas.add(player);
        canvas.add(player.getPlayerSquare());
        canvas.add(player.getPlayerIcon());
    }

    /**
     * Allows player to move with arrow keys within the established bounds
     */
    private void playerMove() {
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.LEFT_ARROW) {
                player.updatePositionLeft();
                playerHitsMine();
                playerAdvanceRound();
            }
        });             
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.RIGHT_ARROW) {
                player.updatePositionRight();
                playerHitsMine();
                playerAdvanceRound();
            }
        });   
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.UP_ARROW) {
                player.updatePositionUp();
                playerHitsMine();
                playerAdvanceRound();
            }
        }); 
        canvas.onKeyDown(event -> {
            if (event.getKey() == Key.DOWN_ARROW) {
                player.updatePositionDown();
                playerHitsMine();
                playerAdvanceRound();
            }
        }); 
    }

    /**
     * Establishes interaction between player and mine  
     */
    public void playerHitsMine() {
        for (Mine mine : mines) {
            if (player.getPlayerSquare().getPosition().equals(mine.getSquare().getPosition())) {
                canvas.removeAll();

                // if player hits mine, wipe canvas, -1 live, reset to same round with rand generation
                GraphicsText lifeLost = new GraphicsText("One life lost"); 
                lifeLost.setCenter(CANVAS_HEIGHT/2 - 75, CANVAS_WIDTH/2);
                lifeLost.setFontStyle(FontStyle.BOLD);
                lifeLost.setFontSize(25);
                canvas.add(lifeLost);
                canvas.draw();
                canvas.pause(2000);
                canvas.remove(lifeLost);
                lives = lives - 1;
                reset();
                
                gameEnd();

                System.out.println("You have lives " + lives + " left");
                break;
            }
        }
    }

    /**
     * Adds lives count to canvas
     */
    public void addlivesLabel() {
        livesLabel = new GraphicsText(); 
        livesLabel.setText("Lives: \n" + lives);
        livesLabel.setPosition(545, 40);
        livesLabel.setFontSize(15);
        canvas.add(livesLabel);
        canvas.draw();
    }

    /**
     * Adds round count to canvas
     */
    public void addRoundLabel() {
        roundLabel = new GraphicsText(); 
        roundLabel.setText("Round: \n" + round);
        roundLabel.setPosition(545, 120);
        roundLabel.setFontSize(15);
        canvas.add(roundLabel);
        canvas.draw();   
    }

    /**
     * Establishes the condition for which the game ends 
     */
    public void gameEnd() {
        if (endGameConditions()){
        } else {
            winGameCondition();
        }
    }
    
    /**
     * Game ends if no lives are left
     * @return true when no lives are left 
     */
    public boolean endGameConditions(){
        if (lives == 0) {
            canvas.removeAll();
            GraphicsText gameOver = new GraphicsText("GAME OVER!"); 
            gameOver.setCenter(CANVAS_HEIGHT/2 - 75, CANVAS_WIDTH/2);
            gameOver.setFontStyle(FontStyle.BOLD);
            gameOver.setFontSize(25);
            canvas.add(gameOver);
            canvas.draw();
            return true; 
        } else {
            return false; 
        }
    }

    /**
     * Player advances a round when they reach the top of the grid
     */
    public void playerAdvanceRound() {
        if (player.getPlayerSquare().getX() <= CANVAS_WIDTH && player.getPlayerSquare().getY() <= 0) {
            canvas.removeAll();

            // if player makes to top row untouched, advance one round, display next round w random generation
            GraphicsText nextRound = new GraphicsText("Good job! Next round."); 
            nextRound.setCenter(CANVAS_HEIGHT/2 - 75, CANVAS_WIDTH/2);
            nextRound.setFontStyle(FontStyle.BOLD);
            nextRound.setFontSize(25);
            canvas.add(nextRound);
            canvas.draw();
            canvas.pause(2000);
            canvas.remove(nextRound);
            round = round + 1;
            reset();

            gameEnd();

            System.out.println("You are on round "+ round);
        }
    }
    

    /**
    * Establishes win condition 
    */
    public boolean winGameCondition() {
        if (round == 11) { // a player wins upon completion of the 10th round with at least one live left
            canvas.removeAll();
            
            GraphicsText win = new GraphicsText("You successfully beat 10 rounds! You win!"); 
            win.setCenter(CANVAS_HEIGHT/2 - 90, CANVAS_WIDTH/2);
            win.setFontStyle(FontStyle.BOLD);
            win.setFontSize(20);

            canvas.add(win);
            canvas.draw();
            return true; 
        } else {
            return false; 
        }
    }

    /**
     * Game Method sequence 
     */
    public void run() {
        reset();
        playerMove();
    }

    /**
     * Resets the game 
     */
    public void reset() {
        mines.clear();
        drawGrid();
        addMine(); 
        addPlayer();
        addlivesLabel();
        addRoundLabel();
    }

    /**
     * Main method 
     */
    public static void main(String[] args) {
        MineFieldNavigator minefieldGame = new MineFieldNavigator(); 
        minefieldGame.run();
    }
}

