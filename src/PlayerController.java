import java.awt.event.KeyEvent;

public class PlayerController {
    public Rect rect;
    public KL keyListener;

    public PlayerController(Rect rect, KL keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public void update(double dt) {
        if(keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            if (rect.y < Constants.SCREEN_HEIGHT - 109) {
                this.rect.y += 0.5;
            }
        }
        else if(keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            if (rect.y > 25) {
                this.rect.y -= 0.5;
            }
        }
    }
}
