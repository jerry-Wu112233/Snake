package personal.jerry.snakegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * UI inspired by the guide https://www.instructables.com/id/How-to-Make-an-Android-Game-Snake/
 */
public class MainGame extends Game {
	SpriteBatch batch;
	@Override
	public void render() {
		super.render();
	}
	@Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new GameDisplay(this));
	}
	@Override
	public void dispose () {
		batch.dispose();

	}
}
