//注意：内部均需要静态static修饰！！！


public class Signal {
    private static volatile Signal self = null;
    private static final Object locker = new Object();

    private Signal(){

    }
    public static Signal getInstance(){
        if(self == null){
            synchronized (locker){
                if(self == null){
                    self = new Signal();
                }
            }
        }
        return self;
    }
    public static void main(String[] args){}


}
