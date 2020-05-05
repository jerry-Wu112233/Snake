package personal.jerry.snakegame;
import com.badlogic.gdx.math.MathUtils;
public class Apples {
    /* X-coordinate of the apple that snakes can consume */
    private int appleXCoordinate;
    /* Y-coordinate of the apple that snakes can consume */
    private int appleYCoordinate;
    public Apples() {
        generateRandomApple();
    }
    public void generateRandomApple() {
        appleXCoordinate = MathUtils.random(GameLogic.boardDimension - 1);
        appleYCoordinate = MathUtils.random(GameLogic.boardDimension - 1);
    }
    public int getAppleXCoordinate() {
        return appleXCoordinate;
    }

    public int getAppleYCoordinate() {
        return appleYCoordinate;
    }
}
