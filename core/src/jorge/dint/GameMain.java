package jorge.dint;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameMain extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float accelX;
	float accelY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("balon.png");

		accelX = 200;
		accelY = 200;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (Gdx.input.getAccelerometerY() < 0) {
			accelX += Gdx.input.getAccelerometerY();
		} else if (Gdx.input.getAccelerometerY() > 0) {
			accelX += Gdx.input.getAccelerometerY();
		}

		if (Gdx.input.getAccelerometerX() < 0) {
			accelY -= Gdx.input.getAccelerometerX();
		} else if (Gdx.input.getAccelerometerX() > 0) {
			accelY -= Gdx.input.getAccelerometerX();
		}

		batch.begin();
		batch.draw(img, accelX, accelY, 200, 200);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

}
