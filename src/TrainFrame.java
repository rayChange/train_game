import java.awt.*;
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
        x+=20;
        y+=20;
        g.fillRect(x,y,20,20);
    }
}
