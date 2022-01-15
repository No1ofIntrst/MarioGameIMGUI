import jade.Window;

// Note to self: For some reason the color doesn't seem to be working for the shader
// This is almost certiantly due to fTexId being assigned to 0 when it shoudnt be

public class Main {
    public static void main(String[] args) {
        Window window = Window.get();
        window.run();
    }
}
