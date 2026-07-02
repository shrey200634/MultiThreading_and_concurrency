import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteCounter {

    private int count =0 ;
    private final ReadWriteLock lock = new ReadWriteLock() {
        @Override
        public Lock readLock() {
            return null;
        }

        @Override
        public Lock writeLock() {
            return null;
        }
    };

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    private void increament (){
        writeLock.lock();
        try {
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteCounter counter = new ReadWriteCounter();

        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i =0 ; i< 10 ; i++){
                    System.out.println(Thread.currentThread().getName() + "read " + counter.getClass());
                }
            }
        };
    }

}
