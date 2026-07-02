import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {

     private final Lock Lock = new ReentrantLock(true ); // we need to make fairness true 

    public void accessResource( ){
        Lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " accured the lock ");
            Thread.sleep(1000);

        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();

        }finally{
            Lock.unlock();
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
