package personal.jerry.snakegame;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Queue;

public class GameLogic {
    /* The amount of squares within the game board */
    private static final int boardSize = 50;
    /* The amount of offset the game board is displaced from the bottom */
    private static final int yOffset = 400;
    private ShapeRenderer rendered = new ShapeRenderer();
    //private Queue<> body = new Queue<>

    public void update(final float delta) {

    }

    public void draw(final int width, final int height, final OrthographicCamera cam) {
        rendered.setProjectionMatrix(cam.combined);
        rendered.begin(ShapeRenderer.ShapeType.Filled);

        rendered.setColor(1, 1, 1, 1);
        rendered.rect(0, yOffset, width, width);

        rendered.setColor(0, 0, 0, 1);
        rendered.rect(5, yOffset + 5, width - 5 * 2, width - 5 * 2);

        rendered.end();
    }
}
