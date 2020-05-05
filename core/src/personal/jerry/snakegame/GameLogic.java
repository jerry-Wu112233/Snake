package personal.jerry.snakegame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

import static com.badlogic.gdx.scenes.scene2d.InputEvent.Type.exit;

public class GameLogic {
    /* The amount of squares within the game board; currently set to 35x35. */
    public static final int boardDimension = 35;
    /* The amount of offset the game board is displaced from the bottom */
    private static final int yOffset = 400;
    /* Created the ShapeRendered to be able to draw out shapes */
    private ShapeRenderer rendered = new ShapeRenderer();
    /* Creates a LinkedList to store all of snake's body*/
    private LinkedList<SnakeBody> snake = new LinkedList<>();
    /* records the time elapse within the game */
    private float clock = 0;
    /* instance of game control */
    private GameControl control = new GameControl();
    /* length of the snake */
    private int snakeSize;
    /* generates an instance of the apples class */
    private Apples apple = new Apples();

    /**
     * Creates a snake of length 2 as the game starts
     */
    public GameLogic() {
        //Creates a tail and a head
        snakeSize = 2;
        snake.addLast(new SnakeBody(13, 13)); //tail
        snake.addFirst(new SnakeBody(13, 12)); //head
    }

    /**
     * update the gameState every timeConstant
     * @param timeConstant the interval that game updates itself
     */
    public void reNewGameState(final float timeConstant) {
        clock += timeConstant;
        // the clock > .11f adjusts the speed of the snake
        if (clock > .11f) {
            clock = 0;
            move();
        }
    }

    /**
     * Helper method to check whether position equals for apple.
     * @return whether or not the coordinates are the same
     */
    public boolean positionEquals(SnakeBody snakeHead, Apples apple) {
        int x1 = snakeHead.getBodyXcoordinate();
        int y1 = snakeHead.getBodyYcoordinate();
        int x2 = apple.getAppleXCoordinate();
        int y2 = apple.getAppleYCoordinate();
        if (x1 == x2 && y1 == y2) {
            return true;
        }
        return false;
    }

    /**
     * Helper method to check whether position equals for apple.
     * @return whether or not the coordinates are the same
     */
    public boolean positionEquals(SnakeBody snakeHead, SnakeBody tempSnakeBody) {
        int x1 = snakeHead.getBodyXcoordinate();
        int y1 = snakeHead.getBodyYcoordinate();
        int x2 = tempSnakeBody.getBodyXcoordinate();
        int y2 = tempSnakeBody.getBodyYcoordinate();
        if (x1 == x2 && y1 == y2) {
            return true;
        }
        return false;
    }

    /**
     * Helper method to retrieve the snake's head position
     * @return the SnakeBody object of the head
     */
    public SnakeBody getSnakeHead() {
        return snake.getFirst();
    }
    /**
     *
     * Adds an appropriate square into the new snake head
     * The last square that is at the end of the snake's body will be removed.
     */
    private void move() {
        int headXcoordinate = getSnakeHead().getBodyXcoordinate();
        int headYCoordinate = getSnakeHead().getBodyYcoordinate();
        int direction = control.retrieveDirection();
        addBody(direction, headXcoordinate, headYCoordinate);
        //determines whether the snake head collides with the snake body
        if (!hasCollided()) {
            // determines if the location of the apple is reasonable
            if (positionEquals(getSnakeHead(), apple)) {
                apple.generateRandomApple();
                while (inSnake()) {
                    apple.generateRandomApple();
                    inSnake();
                }
                snakeSize++;
            }
            snake.removeLast();
        } else {
            for (int i = 0; i < snakeSize - 2; i++) {
                snake.removeLast();
            }
        }
    }

    /**
     * Helper function to check whether the snake has collided with itself.
     * @return - Whether the snake has collided or not.
     */
    public boolean hasCollided() {
        for (SnakeBody body : snake) {
            if (positionEquals(body, getSnakeHead())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper function that checks whether the spawned apple is within the snake's body.
     * @return - Whether the apple is inside or not.
     */
    public boolean inSnake() {
        for (SnakeBody body : snake) {
            if (positionEquals(body, apple)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper function that assists move() to add a snake body
     * @param direction the upcoming direction that the snake heading towards
     * @param currentHeadX the current x position of the snake head
     * @param currentHeadY the current y position of the snake head
     */
    private void addBody(final int direction, final int currentHeadX, final int currentHeadY) {
        switch(direction) {
            case GameControl.UP:
                snake.addFirst(new SnakeBody(currentHeadX, currentHeadY + 1));
                break;
            case GameControl.DOWN:
                snake.addFirst(new SnakeBody(currentHeadX, currentHeadY - 1));
                break;
            case GameControl.LEFT:
                snake.addFirst(new SnakeBody(currentHeadX - 1, currentHeadY));
                break;
            case GameControl.RIGHT:
                snake.addFirst(new SnakeBody(currentHeadX + 1, currentHeadY));
                break;
        }
    }

    /**
     *
     * @param width
     * @param height
     * @param cam OrthographicCamera instance that helps project objects onto the screen
     */
    public void draw(final int width, final int height, final OrthographicCamera cam) {
        //sets up the ShapeRenderer to draw filled shapes in the correct position
        rendered.setProjectionMatrix(cam.combined);
        rendered.begin(ShapeRenderer.ShapeType.Filled);
        //draws rectangles
        rendered.setColor(1, 1, 1, 1);
        rendered.rect(0, yOffset, width, width);
        // ----------------
        rendered.setColor(0, 0, 0, 1);
        rendered.rect(5, yOffset + 5, width - 5 * 2, width - 5 * 2);
        //render snake on screen
        float scaleSnake = width / boardDimension;
        for (SnakeBody part : snake) {
            rendered.rect(part.getBodyXcoordinate() * scaleSnake,
                    part.getBodyYcoordinate() * scaleSnake + yOffset, scaleSnake, scaleSnake);
        }
        rendered.rect(apple.getAppleXCoordinate() * scaleSnake, apple.getAppleYCoordinate() * scaleSnake + yOffset, scaleSnake, scaleSnake);
        rendered.end();
    }
}
