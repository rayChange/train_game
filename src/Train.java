import java.awt.*;

public class Train {

    private int x ;

    private int y ;

    private int height;

    private int width;

    DirEnum dir = DirEnum.DOWN;

    private boolean isMove = false;

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
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,width,height);
        g.setColor(c);

        if (!isMove) return;
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

    public void setIsMove(boolean isMove){
        this.isMove = isMove;
    }
}
