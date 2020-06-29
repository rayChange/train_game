import java.awt.*;

public class Train {

    private int x = 200;

    private int y =200;

    private int height;

    private int width;

    DirEnum dir = DirEnum.DOWN;

    final int SPEED = 1;

    public Train(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Train(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void paint(Graphics g){
        g.fillRect(x,y,width,height);
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
    }

    public void setDir(DirEnum dir){
        this.dir = dir;
    }
}
