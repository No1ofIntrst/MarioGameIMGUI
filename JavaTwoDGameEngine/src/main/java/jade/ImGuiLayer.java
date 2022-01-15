package jade;

import imgui.ImFontAtlas;
import imgui.ImFontConfig;
import imgui.ImGui;
import imgui.ImGuiIO;
import imgui.flag.ImGuiFreeTypeBuilderFlags;
import imgui.gl3.ImGuiImplGl3;

public class ImGuiLayer {
    private boolean showText = false;

    public void ImGuiLayer() {

    }

    public void init(ImGuiImplGl3 imGuiGl3) {
        final ImGuiIO io = ImGui.getIO();
        final ImFontAtlas fontAtlas = io.getFonts();
        final ImFontConfig fontConfig = new ImFontConfig();
        fontConfig.setGlyphRanges(fontAtlas.getGlyphRangesDefault());
        fontConfig.setPixelSnapH(true);
        fontAtlas.addFontFromFileTTF("assets/fonts/segoeui.ttf", 32, fontConfig);
        fontConfig.destroy();

        fontAtlas.setFlags(ImGuiFreeTypeBuilderFlags.LightHinting);
        fontAtlas.build();

        imGuiGl3.init("#version 330 core");
    }

    public void imgui() {
        ImGui.begin("Cool Window");

        if (ImGui.button("Good for you")) {
            showText = true;
        }

        if (showText) {
            ImGui.text("You clicked a button");
            if (ImGui.button("Stop showing text")) {
                showText = false;
            }
        }

        ImGui.end();
    }
}
