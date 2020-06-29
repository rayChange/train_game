import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrainFrame extends Frame {

    Train mTrain = new Train(200,200,50,50);

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
        mTrain.paint(g);

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
            if(isRedUp) mTrain.setDir(DirEnum.UP);
            if(isRedDown) mTrain.setDir(DirEnum.DOWN);
            if(isRedLeft) mTrain.setDir(DirEnum.LEFT);
            if(isRedRight) mTrain.setDir(DirEnum.RIGHT);

        }





    }



}


