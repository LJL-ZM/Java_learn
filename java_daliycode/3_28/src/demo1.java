public class demo1 {
    private String name = "hahahah";
    private static Object obj = new Object();
    private demo1(){}
    private volatile static demo1 demo = null;
    public static demo1 getInstance(){
        if(demo == null){
            synchronized (obj){
                if(demo == null){
                    demo = new demo1();
                }
            }
        }
        return demo;
    }
}
