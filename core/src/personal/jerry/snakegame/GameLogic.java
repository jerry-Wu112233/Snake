package personal.jerry.snakegame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;

public class GameLogic {
    /* The amount of squares within the game board; currently set to 35x35. */
    private static final int boardSize = 35;
    /* The amount of offset the game board is displaced from the bottom */
    private static final int yOffset = 400;
    /* Created the ShapeRendered to be able to draw out shapes */
    private ShapeRenderer rendered = new ShapeRenderer();
    //private Queue<> body = new Queue<>

    public void update(final float delta) {

    }

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

        rendered.end();
    }
}
