import java.awt.*;

public class Train {

    private int x ;

    private int y ;

    private int height = 50;

    private int width = 50;

    DirEnum dir = DirEnum.DOWN;

    private boolean isMove = false;

    final int SPEED = 1;

    private TrainFrame tf;

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

    public Train(int x, int y, TrainFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
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

    public void tikatika(){
        tf.gasList.add(new Gas(this.x,this.y,this.dir)) ;
    }
}
