import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) throws InterruptedException {
        TrainFrame tf = new TrainFrame();
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
