public class Ball {

    public Rect rect;
    public Rect leftPaddle, rightPaddle;

    private double vy = 10.0;
    private double vx = -150.0;
    //velocity x and y

    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
    }

    public void update(double dt) {
        if(vx < 0) {

        }
        else if(vx > 0) {

        }

        this.rect.x += vx * 2;
        this.rect.y += vy * 2;

    }
}
