import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrainFrame extends Frame {

    private int x = 200;

    private int y =200;


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
        System.out.println("paint");
//        x+=20;
//        y+=20;
        g.fillRect(x,y,20,20);
    }


    class MykeyListen extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode){
                case KeyEvent.VK_UP:
                    y-=10;
                    break;
                case KeyEvent.VK_DOWN:
                    y+=10;
                    break;
                case KeyEvent.VK_LEFT:
                    x-=10;
                    break;
                case KeyEvent.VK_RIGHT:
                    x+=10;
                    break;
                default:
                    break;
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("release");
        }
    }



}


