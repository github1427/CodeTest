/**
 * 一个简单的死锁的例子
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1=new Thread(new DeadLock(true));
        Thread t2=new Thread(new DeadLock(false));
        t1.start();
        t2.start();
//        new DeadLock(true).addd();
//        new DeadLock(true).addd();
//        new DeadLock(true).addd();
//        new DeadLock(true).addd();
//        new DeadLock(true).addd();
    }
}
class DeadLock implements Runnable{
    private boolean bool;
    public DeadLock(boolean flag){
        this.bool=flag;
    }
    private static Object object1=new Object();
    private static Object object2=new Object();
    private String s1="hello";
    private String s2="hello";

    @Override
    public void run() {
        while (true){
            if (bool){
                synchronized (object1){
                    System.out.println("object1111");
                    synchronized (object2){
                        System.out.println("object2222");
                    }
                }
            }else {
                synchronized (object2){
                    System.out.println("object3333");
                    synchronized (object1){
                        System.out.println("object4444");
                    }
                }
            }
        }
    }
    public void addr(){
        System.out.println(object1);
        System.out.println(object2);
    }
    public void addd(){
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
