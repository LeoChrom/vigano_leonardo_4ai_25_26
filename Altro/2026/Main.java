package io.github.some_example_name;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.files.FileHandle;

import java.util.Random;


/*   __  __       _
    |  \/  | __ _(_)_ __
    | |\/| |/ _` | | '_ \
    | |  | | (_| | | | | |
    |_|  |_|\__,_|_|_| |_|  Entry point dell'applicazione.
*/
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private TextureRegion region;
    private Sprite sprite;
    private int mouseX;
    private BitmapFont font;
    private String text;

    private Texture lamp;
    private TextureRegion lampRegion;
    private Random r;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        region = new TextureRegion(image, 20, 20, 50, 50);
        FileHandle file = new FileHandle("prova.txt");
        text = file.readString();
        font = new BitmapFont();
        lamp = new Texture("lampadina.png");
        lampRegion = new TextureRegion(image, 0, 0, 40, 52);
        r = new Random();
    }

    @Override
    public void render() {
        // Update application
        mouseX = Gdx.input.getX();
        boolean isAPressed = Gdx.input.isKeyPressed(Keys.A);
        boolean isEscPressed = Gdx.input.isKeyPressed(Keys.ESCAPE);

        float delta = Gdx.graphics.getDeltaTime();

        boolean leftPressed = Gdx.input.isButtonPressed(Input.Buttons.LEFT);
        boolean rightPressed = Gdx.input.isButtonPressed(Input.Buttons.RIGHT);

        // Render
        ScreenUtils.clear(Color.BLACK);
        batch.begin();
        // batch.disableBlending();
        // disegno lo sfondo
        // batch.enableBlending();
        batch.draw(image, 100, 500);

        if (isAPressed == true) {
            batch.draw(image, 0, 0);
        }

        if (leftPressed) {
            batch.draw(image, 20, 20);
        }

        batch.draw(image, mouseX, 250);
        batch.draw(region, 400, 250);

        batch.draw(lamp, 0,200);

        for(int i=0;i<200;i++){
            int x = r.nextInt(100, 600);
            batch.draw(lamp, x,200);

        }
        font.draw(batch, "Ciao", 10, 500);
        font.draw(batch, String.valueOf(mouseX), 10, 520);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}






