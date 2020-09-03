import javax.swing.ImageIcon;

public class human extends Thread{
    static int count;
    boolean run = true;
    
    @Override
    public void run(){
      main.imgHuman.setIcon(new ImageIcon(getClass().getResource("resources/sleepHuman.jpg")));
      try{
          while(run){
              synchronized(this){
                  wait();
              }
              if(this.count == 0){
                  main.imgHuman.setIcon(new ImageIcon(getClass().getResource("resources/sleepHuman.jpg")));
              }
              else if(this.count == 1){
                  main.imgHuman.setIcon(new ImageIcon(getClass().getResource("resources/wakeupHuman.png")));
              }
          }
      }catch(InterruptedException e){
          try {
                Thread.sleep(3000);
                main.imgHuman.setIcon(new ImageIcon(getClass().getResource("resources/interruptHuman.jpg")));
                Thread.sleep(3800);
                main.imgHuman.setIcon(new ImageIcon(getClass().getResource("resources/callPolice.jpg")));
                main.Police.interrupt();
             } catch (InterruptedException ex) {
            }
      }
    }
    
}
    

