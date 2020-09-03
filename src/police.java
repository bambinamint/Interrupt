import javax.swing.ImageIcon;

public class police extends Thread{
    static int count;
    boolean run = true;
    
    @Override
    public void run(){
        main.imgPolice.setIcon(new ImageIcon(getClass().getResource("resources/police.jpg")));
        try{
            while(run){
                synchronized(this){
                    wait();
                }
            }
        }catch(InterruptedException er){
            try {
                Thread.sleep(4000);
                main.imgPolice.setIcon(new ImageIcon(getClass().getResource("resources/interruptPolice.jpg")));
                Thread.sleep(4200);
                main.imgThief.setIcon(new ImageIcon(getClass().getResource("resources/arrestThief.jpg")));
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
