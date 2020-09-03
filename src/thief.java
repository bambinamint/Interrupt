import javax.swing.ImageIcon;

public class thief extends Thread{
    static int count;
    boolean run = true;
    
    @Override
    public void run(){
        main.imgThief.setIcon(new ImageIcon(getClass().getResource("resources/thief.jpg")));
        try{
            while(run){
                synchronized(this){
                    wait();
                }
                if(this.count == 0){
                    main.imgThief.setIcon(new ImageIcon(getClass().getResource("resources/sleepThief.png")));
                    main.btThief.setEnabled(false);
                }
                    else if(this.count == 1){
                        main.imgThief.setIcon(new ImageIcon(getClass().getResource("resources/wakeupThief.jpg")));
                        main.btThief.setEnabled(true);
                    }
            }
        }catch(InterruptedException er){
            try {
                Thread.sleep(1000);
                main.imgThief.setIcon(new ImageIcon(getClass().getResource("resources/steal.jpg")));
                main.Dog.interrupt();
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
