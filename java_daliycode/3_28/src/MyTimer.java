import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;


//public class MyTimer {
//    public static void main(String[] args){
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("3000");
//            }
//        }, 3000);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("2000");
//            }
//        }, 2000);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("1000");
//            }
//        }, 1000);
//    }
//}


//class MyTask implements Comparable<MyTask>{
//    Runnable runnable;
//    long time;
//    public MyTask(Runnable runnable, long delay){
//        this.runnable = runnable;
//        this.time = System.currentTimeMillis() + delay;
//    }
//    long getTime(){
//        return this.time;
//    }
//    @Override
//    public int compareTo(MyTask obj){
//        return (int)(time - obj.time);
//    }
//}
//
//public class MyTimer {
//    private PriorityQueue<MyTask> queue = new PriorityQueue<>();
//    private Object locker = new Object();
//
//    public void schedule(Runnable runnable, long delay){
//        synchronized (locker){
//            queue.add(new MyTask(runnable, delay));
//            locker.notify();
//        }
//    }
//
//    public MyTimer(){
//        Thread listenT = new Thread(() -> {
//            try{
//                synchronized (locker){
//                    while (true){
//                        while(queue.isEmpty()){
//                            locker.wait();
//                        }
//                        MyTask task = queue.peek();
//                        long curTime = System.currentTimeMillis();
//                        if(curTime >= task.getTime()){
//                            task.runnable.run();
//                            queue.poll();
//                        }
//                        else{
//                            locker.wait(task.getTime() - curTime);
//                        }
//                    }
//                }
//            } catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//        listenT.start();
//    }
//
//    public static void main(String[] args){
//        MyTimer timer = new MyTimer();
//        timer.schedule(() -> {
//                System.out.println("3000");
//        }, 3000);
//    }
//}





public class MyTimer {
    public static void main(String[] args){

    }
}