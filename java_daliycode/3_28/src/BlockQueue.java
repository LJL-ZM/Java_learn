import java.util.ArrayDeque;
import java.util.Queue;

class MyThread extends Thread{
    @Override
    public void run(){
        //...
    }
}

public class BlockQueue {
    private volatile String[] arrS = new String[100];
    private volatile int beg = 0;
    private volatile int end = 0;
    private volatile  int size = 0;
    private final int minWater = 30;
    private final int maxWater = 70;
    public void put(String in){
        synchronized (this){
            try {
                while (size == arrS.length) {
                    this.wait();
                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            arrS[end] = in;
            end = (end + 1) % arrS.length;
            size++;
            if(size > maxWater){
                this.notifyAll();
            }
        }
    }
    public String take(){
        String ret =  null;
        synchronized (this){
            try{
                while(size == 0){
                    this.wait();
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            ret = arrS[beg];
            beg = (beg + 1) % arrS.length;
            size--;
            if(size < minWater){
                this.notifyAll();
            }
        }
        return ret;
    }

    static int cnt = 0;
    public static void main(String[] args) throws InterruptedException{
        BlockQueue q = new BlockQueue();
        //生产者
        Thread t1 = new Thread(() -> {
            while(true){
                String in = "cnt : " + cnt;
                q.put(in);
                cnt++;
                System.out.println("生产了->" + in);
                try{
                    Thread.sleep(500);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        //消费者
        Thread t2 = new Thread(() -> {
            while(true){
                String out = q.take();
                System.out.println(out);
                try{
                    Thread.sleep(700);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                //...
            }
        };
        Thread t3 = new Thread(r3);
        Thread t4 = new MyThread();
        Runnable r5 = () -> {};
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}



