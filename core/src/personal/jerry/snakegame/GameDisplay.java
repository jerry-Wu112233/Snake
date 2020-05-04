package personal.jerry.snakegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameDisplay implements Screen {
    private MainGame activity;
    private GameLogic state;
    /* The width for the dimension of the game screen. */
    private static final int boardWidth = 400;
    /* The height for the dimension of the game screen. */
    private static final int boardHeight = 1200;
    /* set up the orthographic camera so the graphics can be projected onto the screen in 2D. */
    private OrthographicCamera cam = new OrthographicCamera(boardWidth, boardHeight);
    private Viewport view;
    public GameDisplay(final MainGame game) {
        this.state = new GameLogic();
        this.activity = game;
        //setting up the camera
        //the false in the first parameter is ensuring that moving an object up or down changes the y-coordinate of the object
        cam.setToOrtho(false, boardWidth, boardHeight);
        //ensuring that everything is stretched or shrinked to fit the screen
        view = new FitViewport(boardWidth, boardHeight, cam);
        view.apply();
    }
    @Override
    public void show() {

    }
    @Override
    /**
     * timeConstant is the a timer to know when to update the game logic
     */
    public void render(final float timeConstant) {
        cam.update();
        view.apply();

        state.update(timeConstant);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //draws the outline of the board
        state.draw(boardWidth, boardHeight, cam);
    }
    @Override
    /**
     * This updates the viewport when the game window is resized
     */
    public void resize(final int w, final int h) {
        view.update(boardWidth, boardHeight);
    }
    @Override
    public void pause() {

    }
    @Override
    public void resume() {

    }
    @Override
    public void hide() {

    }
    @Override
    public void dispose() {

    }
}
