import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {

    private final Lock UnfairLock = new ReentrantLock();

    public void accessResource( ){
        UnfairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " accured the lock ");
            Thread.sleep(1000);

        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();

        }finally{
            UnfairLock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock ");
        }
    }
    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample() ;

        Runnable task = new Runnable() {
            @Override
            public void run (){
                example.accessResource();
            }
        };

       Thread thread1 = new Thread(task, "Thread1");
       Thread thread2 = new Thread(task, "Thread2");
       Thread thread3 = new Thread(task, "Thread3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
    
}
