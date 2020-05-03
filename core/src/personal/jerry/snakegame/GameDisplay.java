package personal.jerry.snakegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import jdk.javadoc.internal.tool.Main;

public class GameDisplay implements Screen {
    private MainGame activity;
    private GameLogic state;
    private static final int width = 600;
    private static final int height = 1000;
    private OrthographicCamera cam = new OrthographicCamera(width, height);
    private Viewport view;
    public GameDisplay(final MainGame game) {
        this.state = new GameLogic();
        this.activity = game;
        cam.setToOrtho(false, width, height);
        view = new FitViewport(width, height, cam);
        view.apply();
    }
    @Override
    public void show() {

    }
    @Override
    public void render(final float delta) {
        cam.update();
        view.apply();

        state.update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        state.draw(width, height, cam);
    }
    @Override
    public void resize(final int w, final int h) {
        view.update(width, height);
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
