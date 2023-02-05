import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable{

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Rect playerOne;
    public Rect ai;
    public Rect ballRect;
    public PlayerController playerController;
    public AiController aiController;
    public Ball ball;
    public Text lefScoreText, rightScoreText;
    public boolean isRunning = true;



    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        lefScoreText = new Text(0, new Font("Arial", Font.BOLD, 20), 60, 70);
        rightScoreText = new Text(0, new Font("Arial", Font.BOLD, 20), Constants.SCREEN_WIDTH - 50 -20, 70);

        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Rect(Constants.HZ_PADDING, 200, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.WHITE);
        playerController = new PlayerController(playerOne, keyListener);

        ai = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH - Constants.HZ_PADDING, 200, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, Color.WHITE);
        ballRect = new Rect(400, 300, Constants.BALL_WIDTH, 10, Constants.PADDLE_COLOR);
        ball = new Ball(ballRect, playerOne, ai, lefScoreText, rightScoreText);

        aiController = new AiController(new PlayerController(ai), ballRect);
    }

    public void update(double dt) {

        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage, 0, 0, this);

        playerController.update(dt);
        aiController.update(dt);
        ball.update(dt);
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        lefScoreText.draw(g2);
        rightScoreText.draw(g2);
        playerOne.draw(g2);
        ai.draw(g2);
        ballRect.draw (g2);
    }

    public void stop() {
        isRunning = false;
    }

    public void run() {
        double lastFrameTime = 0.0;
        while (isRunning) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

        }
        this.dispose();
        return;
    }
}
