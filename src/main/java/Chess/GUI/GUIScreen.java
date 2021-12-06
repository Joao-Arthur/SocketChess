package Chess.GUI;

import java.awt.Component;

public interface GUIScreen {
    public void dispose();

    public Component getScreen();

    public void enable();

    public void disable();
}
