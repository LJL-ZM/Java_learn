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



abstract class MyTimerTask implements Runnable{

}

class MyTask implements Comparable<MyTask>{
    long time;
    Runnable runnable;
    //构造
    public MyTask(Runnable runnable, long delay){
        this.time = System.currentTimeMillis() + delay;
        this.runnable = runnable;
    }

    //获取属性
    Runnable getRunnable(){
        return runnable;
    }
    long getTime(){
        return time;
    }

    //支持可比较

    @Override
    public int compareTo(MyTask o) {
        return (int)(time - o.time);
    }
}
public class MyTimer {
    PriorityQueue<MyTask> queue = new PriorityQueue<>();
    Object locker = new Object();

    //投送任务
    public void schedule(MyTimerTask task, long time){
        synchronized (locker){
            queue.add(new MyTask(task, time));
            locker.notify();
        }
    }

    //运行
    public MyTimer(){
        Thread t = new Thread(() -> {
            synchronized (locker){
                try{
                    while(true) {
                        while (queue.isEmpty()) {
                            locker.wait();
                        }
                        MyTask task = queue.peek();
                        long curTime = System.currentTimeMillis();
                        if(task.getTime() <= curTime){
                            task.getRunnable().run();
                            queue.poll();
                        } else {
                            locker.wait(task.getTime() - curTime);
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public static void main(String[] args){
        MyTimer timer = new MyTimer();
        timer.schedule(new MyTimerTask() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        }, 3000);
        timer.schedule(new MyTimerTask() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        }, 2000);
        timer.schedule(new MyTimerTask() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        }, 1000);
    }
}