package personal.jerry.snakegame;

/**
 * Custome data structure that defines the body of the Snake
 */
public class SnakeBody {
    /* X-coordinate of every single snake body */
    private int bodyXcoordinate;
    /* Y-coordinate of every single snake body */
    private int bodyYcoordinate;

    /**
     *
     * @param setXcoordinate sets the x-coordinate a single snake body
     * @param setYcoordinate sets the y-coordinate a single snake body
     */
    public SnakeBody(final int setXcoordinate, final int setYcoordinate) {
        this.bodyXcoordinate = setXcoordinate;
        this.bodyYcoordinate = setYcoordinate;
    }
    public int getBodyXcoordinate() {
        return this.bodyXcoordinate;
    }
    public int getBodyYcoordinate() {
        return this.bodyYcoordinate;
    }
}
