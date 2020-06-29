import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrainFrame extends Frame {

    private int x = 200;

    private int y =200;

    DirEnum dir = DirEnum.DOWN;

    final int SPEED = 1;

    public TrainFrame(){
        setSize(300,400);
        setResizable(false);
        setVisible(true);
        setTitle("train start");
        addKeyListener(new MykeyListen());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    @Override
    public void paint(Graphics g) {
//        System.out.println("paint");
        g.fillRect(x,y,20,20);

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


    class MykeyListen extends KeyAdapter{

        boolean isRedUp = false;
        boolean isRedDown = false;
        boolean isRedLeft = false;
        boolean isRedRight = false;



        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_UP:
                    isRedUp = true;
                    break;
                case KeyEvent.VK_DOWN:
                    isRedDown = true;
                    break;
                case KeyEvent.VK_LEFT:
                    isRedLeft= true;
                    break;
                case KeyEvent.VK_RIGHT:
                    isRedRight = true;
                    break;
                default:
                    break;
            }
            setTrainDir();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_UP:
                    isRedUp = false;
                    break;
                case KeyEvent.VK_DOWN:
                    isRedDown = false;
                    break;
                case KeyEvent.VK_LEFT:
                    isRedLeft= false;
                    break;
                case KeyEvent.VK_RIGHT:
                    isRedRight = false;
                    break;
                default:
                    break;
            }
            setTrainDir();
        }

//
        public void setTrainDir(){
            if(isRedUp) dir = DirEnum.UP;
            if(isRedDown) dir = DirEnum.DOWN;
            if(isRedLeft) dir = DirEnum.LEFT;
            if(isRedRight) dir = DirEnum.RIGHT;

        }





    }



}


