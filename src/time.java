public class time extends Thread{
    public static boolean running;
    
    time(){
        running = true;
    }
    public void run(){
        int i = 0, y = 0;
        try{
            while(running){
                    if(i == 24){
                        i = 0;
                    }
                    if(y < 10){
                        main.labelTime.setText(Integer.toString(i)+":0"+Integer.toString(y));
                    }
                    synchronized(main.Human){
                        synchronized(main.Dog){
                            synchronized(main.Thief){
                                if(i == 6){
                                    main.Human.count = 1;
                                    main.Dog.count = 0;
                                    main.Thief.count = 0;
                                    main.Human.notify();
                                    main.Dog.notify();
                                    main.Thief.notify();
                                }
                                if(i == 22){
                                    main.Human.count = 0;
                                    main.Dog.count = 1;
                                    main.Thief.count = 1;
                                    main.Human.notify();
                                    main.Dog.notify();
                                    main.Thief.notify(); 
                                }
                            }
                        }        
                    }
                        for(y = 0; y < 60; y++){
                            Thread.sleep(10);
                            if(y < 10){
                                main.labelTime.setText(Integer.toString(i)+":0"+Integer.toString(y));
                            }else{
                                main.labelTime.setText(Integer.toString(i)+":"+Integer.toString(y));
                            }   
                        }
                    i++;
        }
 
            }catch(InterruptedException e){
            }              
    }
}
