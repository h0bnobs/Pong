import java.awt.event.KeyEvent;

public class PlayerController {
    public Rect rect;
    public KL keyListener;

    public PlayerController(Rect rect, KL keyListener) {
        this.rect = rect;
        this.keyListener = keyListener;
    }

    public PlayerController(Rect rect) {
        this.rect = rect;
        this.keyListener = null;
    }

    public void update(double dt) {
        if (keyListener != null) {
            if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
                moveDown(dt);
            } else if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
                moveUp(dt);
            }
        }
    }
    public void moveUp (double dt){
        if (rect.y > 25) {
            this.rect.y -= 0.5;
        }
    }
    public void moveDown (double dt){
        if (rect.y < Constants.SCREEN_HEIGHT - 109) {
            this.rect.y += 0.5;
        }
    }
}
