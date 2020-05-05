package personal.jerry.snakegame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameControl {
    /* variable that stores the direction that snake is currently going */
    private int vectorHeading;
    /* variable that stores the upcoming direction that the snake is going */
    private int upcomingDirection;
    /* CONTROL STATE CONSTANTS */
    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 4;
    public GameControl() {
        vectorHeading = 0;
        upcomingDirection = 0;
    }
    public int retrieveDirection() {
        vectorHeading = upcomingDirection;
        return vectorHeading;
    }
    /**
     * updates the direction that snake is going according to keyboard inputs
     */
    public void updateDirection() {
        int directionDesired = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            directionDesired = UP;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            directionDesired = DOWN;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            directionDesired = LEFT;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            directionDesired = RIGHT;
        }

        if (directionDesired == UP && vectorHeading != DOWN) {
            upcomingDirection = directionDesired;
        } else if (directionDesired == DOWN && vectorHeading != UP) {
            upcomingDirection = directionDesired;
        } else if (directionDesired == LEFT && vectorHeading != RIGHT) {
            upcomingDirection = directionDesired;
        } else if (directionDesired == RIGHT && vectorHeading != LEFT) {
            upcomingDirection = directionDesired;
        }
    }

}
