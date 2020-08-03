public class Chi extends Thread{
    private Bao bz;
    public Chi(Bao bz){
        this.bz=bz;
    }
    public void run(){
        synchronized (bz){
            if(bz.flag==false) {
                try {
                    bz.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("吃货正在吃"+bz.pi+bz.xian+"的包子");
            bz.flag=false;
            bz.notify();
            System.out.println("吃货已经吃完了"+bz.pi+bz.xian+"的包子");


        }
    }

}
