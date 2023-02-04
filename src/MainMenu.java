import javax.swing.JFrame;
import java.awt.*;

public class MainMenu extends JFrame implements Runnable{

    public Graphics2D g2;
    public KL keyListener = new KL();
    public ML mouseListener = new ML();
    public Text startGame, exitGame, pong;

    public MainMenu() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);

        this.startGame = new Text("Play", new Font("Arial", Font.BOLD, 30), Constants.SCREEN_WIDTH / 2.0 -50.0, Constants.SCREEN_HEIGHT / 2.0, Color.WHITE);
        this.exitGame = new Text("Exit", new Font("Arial", Font.BOLD, 30), Constants.SCREEN_WIDTH / 2.0 - 50.0, Constants.SCREEN_HEIGHT / 2.0 + 60, Color.WHITE);
        this.pong = new Text("Pong", new Font("Arial", Font.BOLD, 35), Constants.SCREEN_WIDTH / 2.0 -60.0, Constants.SCREEN_HEIGHT / 2.0 - 80, Color.WHITE);

        g2 = (Graphics2D)getGraphics();
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(), getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage, 0, 0, this);

        if(mouseListener.getMouseX() > startGame.x && mouseListener.getMouseX() < startGame.x + startGame.width &&
            mouseListener.getMouseY() > startGame.y - startGame.height / 2.0 && mouseListener.getMouseY() < startGame.y + startGame.height / 2.0) {
            //change colour to grey
            startGame.color = new Color(132, 132, 132);
        } else {
            startGame.color = Color.WHITE;
        }

        if(mouseListener.getMouseX() > exitGame.x && mouseListener.getMouseX() < exitGame.x + exitGame.width &&
                mouseListener.getMouseY() > exitGame.y - exitGame.height / 2.0 && mouseListener.getMouseY() < exitGame.y + exitGame.height / 2.0) {
            //change colour to grey
            exitGame.color = new Color(132, 132, 132);
        } else {
            exitGame.color = Color.WHITE;
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.PINK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        startGame.draw(g2);
        exitGame.draw(g2);
        pong.draw(g2);
        //System.out.println(mouseListener.getMouseX());
        //System.out.println(mouseListener.getMouseY());
    }

    public void run() {
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

        }

    }
}
