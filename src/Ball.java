import java.util.*;

public class Ball {

    public Rect rect;
    public Rect leftPaddle, rightPaddle;
    Text leftScoreText, rightScoreText;

    private double vy = 0.1;
    private double vx = -0.4;
    Random rand;
    //velocity x and y

    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle, Text leftScoreText, Text rightScoreText) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.rand = new Random();
        this.leftScoreText = leftScoreText;
        this.rightScoreText = rightScoreText;
    }

    public void update(double dt) {
        if (vx < 0) {
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.width && this.rect.x + this.rect.width >= this.leftPaddle.x  &&
                    this.rect.y >= this.leftPaddle.y && this.rect.y <= this.leftPaddle.y + this.leftPaddle.height) {
                this.vx *= -1;
                this.vy *= (rand.nextDouble() <= 0.5) ? 1 : -1;
            }
//            else if (this.rect.x + this.rect.width < this.leftPaddle.x) {
//                System.out.println("You lost");
//            }
        } else if (vx > 0) {
            if (this.rect.x + this.rect.width >= this.rightPaddle.x && this.rect.x <= this.rightPaddle.x + this.rightPaddle.width &&
                    this.rect.y >= this.rightPaddle.y && this.rect.y <= this.rightPaddle.y + this.rightPaddle.height) {
                this.vx *= -1;
                this.vy *= (rand.nextDouble() <= 0.5) ? 1 : -1;
            }
//            else if (this.rect.x + this.rect.width > this.rightPaddle.x + this.rightPaddle.width) {
//                System.out.println("Ai lost a point");
//            }
        }

        if(vy > 0) {
            if(this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT - 5) {//bottom of screen
                this.vy *= -1;
            }
        } else if(vy < 0) {
            if(this.rect.y < 25) {//top of screen
                this.vy *= -1;
            }
        }

        this.rect.x += vx * 1;
        this.rect.y += vy * 1;

        if(this.rect.x + this.rect.width < leftPaddle.x -20) {//if the ball has gone off the left side of the screen
            score(rightScoreText);
            if(Integer.parseInt(rightScoreText.text) >= Constants.WIN_SCORE) {//win condition for AI
                Main.changeState(2);
            }
        } else if(this.rect.x > rightPaddle.x + rightPaddle.width + 20) {//if the left side of the ball is greater than the right side of the right paddle
            score(leftScoreText);
            if(Integer.parseInt(leftScoreText.text) >= Constants.WIN_SCORE) {
                Main.changeState(2);
            }
        }
    }
    private void score(Text leftScoreText) {
        int leftScore = Integer.parseInt(leftScoreText.text);
        leftScore ++;
        leftScoreText.text = "" + leftScore;
        this.rect.x = Constants.SCREEN_WIDTH / 2.0;
        this.rect.y = Constants.SCREEN_HEIGHT / 2.0;
        this.vx = -0.4;
        this.vy = 0.1;
    }
}

