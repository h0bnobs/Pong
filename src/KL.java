import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {

    private final boolean[] keyPressed = new boolean[128];//initialise new boolean variable

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keyPressed[keyEvent.getKeyCode()] = true;//sets true the value of the key thats been pressed.

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keyPressed[keyEvent.getKeyCode()] = false;//sets true the value of the key being released.
    }

    public boolean isKeyPressed(int keyCode) {
        return keyPressed[keyCode];//returns whether the key pressed is true inside of the array
    }
}
