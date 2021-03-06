import java.awt.*;

public class Gas {

    private int x;
    private int y;
    private DirEnum dir;

    private final static int WIDTH = 10;
    private final static int HEIGHT = 10;

    private final static int SPEED = 5;

    private boolean isAlive = true;

    TrainFrame tf;

    public Gas(int x, int y, DirEnum dir,TrainFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }




    public void paint(Graphics g){
        if(!isAlive){
            tf.gasList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        if(x<0 || y<0 || x>TrainFrame.WIDTH || y>TrainFrame.HEIGHT) isAlive = false;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirEnum getDir() {
        return dir;
    }

    public void setDir(DirEnum dir) {
        this.dir = dir;
    }


}
