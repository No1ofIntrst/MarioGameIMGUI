package jade;

import components.Sprite;
import components.SpriteRenderer;
import components.Spritesheet;
import imgui.ImGui;
import org.joml.Vector2f;
import util.AssetPool;

public class LevelEditorScene extends Scene{

    private GameObject obj1;
    private Spritesheet sprites;

    public LevelEditorScene() {

    }

    @Override
    public void init() {
        loadResources();

        this.camera = new Camera(new Vector2f(-250, 0));

        sprites = AssetPool.getSpritesheet("assets/images/spritesheet.png");

        int xOffset = 10;
        int yOffset = 10;

        float totalWidth = (float)(600 - xOffset * 2);
        float totalHeight = (float)(300 - yOffset * 2);
        float sizeX = totalWidth / 100.0f;
        float sizeY = totalHeight / 100.0f;
        float padding = 0;

        obj1 = new GameObject("Object 1",
                new Transform(new Vector2f(200,100), new Vector2f(265,256)), 3);
        obj1.addComponent(new SpriteRenderer(new Sprite(
                AssetPool.getTexture("assets/images/blendImage1.png")
        )));
        this.addGameObjectToScene(obj1);

        GameObject obj2 = new GameObject("Object 2",
                new Transform(new Vector2f(400,100), new Vector2f(265,256)), 2);
        obj2.addComponent(new SpriteRenderer(new Sprite(
                AssetPool.getTexture("assets/images/blendImage2.png")
        )));
        this.addGameObjectToScene(obj2);


    }

    private void loadResources() {
        AssetPool.getShader("assets/shaders/default.glsl");
        AssetPool.addSpritesheet("assets/images/spritesheet.png",
                new Spritesheet(AssetPool.getTexture("assets/images/spritesheet.png"),
                16, 16, 26, 0));
    }

    // Temporary
    private int spriteIndex = 0;
    private float spriteFlipTime = 0.2f;
    private float spriteFlipTimeLeft = 0.0f;

    @Override
    public void update(float dt) {
        //System.out.println("FPS: " + (1.0f / dt));

        for (GameObject go : this.gameObjects) {
            go.update(dt);
        }

        this.renderer.render();
    }

    @Override
    public void imgui() {
        ImGui.begin("Test window");
        ImGui.text("Some random text");
        ImGui.end();
    }
}
