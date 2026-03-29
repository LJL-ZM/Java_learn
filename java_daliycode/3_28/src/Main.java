//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int cnt = 0;
    public static void main (String[] args) throws InterruptedException{
        Object o1 = new Object();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 50000; i++){
                synchronized (o1){
                    cnt++;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for(int j = 0; j < 50000; j++){
                synchronized (o1){
                    cnt++;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("cnt:" + cnt);
    }
}