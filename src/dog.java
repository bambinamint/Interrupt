import javax.swing.ImageIcon;

public class dog extends Thread{
    static int count;
    boolean run = true;
    
    @Override
    public void run(){
        main.imgDog.setIcon(new ImageIcon(getClass().getResource("resources/wakeupDog.jpeg")));
        try{
            while(run){
                synchronized(this){
                    wait();
                }
                if(this.count == 0){
                    main.imgDog.setIcon(new ImageIcon(getClass().getResource("resources/sleepDog.jpg")));
                }
                    else if(this.count == 1){
                        main.imgDog.setIcon(new ImageIcon(getClass().getResource("resources/wakeupDog.jpeg")));   
                    }
            }
        }catch(InterruptedException er){
            try {
                Thread.sleep(1000);
                main.imgDog.setIcon(new ImageIcon(getClass().getResource("resources/roarDog.jpg")));
                main.Human.interrupt();
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
