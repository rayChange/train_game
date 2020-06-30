import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TrainFrame extends Frame {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 500;


    Train mTrain = new Train(200,200,this);
    List<Gas> gasList = new ArrayList<Gas>(3);

    public TrainFrame(){
        setSize(WIDTH,HEIGHT);
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
        for (Gas gas:gasList) {
             gas.paint(g);
        }
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g){
         if(offScreenImage == null){
             offScreenImage = createImage(WIDTH,HEIGHT);
         }
         Graphics offScreenG = offScreenImage.getGraphics();
         Color c = offScreenG.getColor();
         offScreenG.setColor(Color.BLACK);
         offScreenG.fillRect(0,0,WIDTH,HEIGHT);
         offScreenG.setColor(c);
         paint(offScreenG);
         g.drawImage(offScreenImage,0,0,null);

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
                case KeyEvent.VK_CONTROL:
                    mTrain.tikatika();
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
            if(!isRedRight && !isRedLeft && !isRedDown && !isRedUp) {
                mTrain.setIsMove(false);
            }else{
                mTrain.setIsMove(true);
                if(isRedUp) mTrain.setDir(DirEnum.UP);
                if(isRedDown) mTrain.setDir(DirEnum.DOWN);
                if(isRedLeft) mTrain.setDir(DirEnum.LEFT);
                if(isRedRight) mTrain.setDir(DirEnum.RIGHT);
            }


        }





    }



}


