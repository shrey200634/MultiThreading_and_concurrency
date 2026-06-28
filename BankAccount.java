import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    int balance =100;
    private Lock lock = new ReentrantLock(); 

    public   void with( int ammount ){
         
          

        }
    


    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount() ;
        Runnable task = new Runnable() {
            @Override
            public void run (){
                bankAccount.with(50);
            }
            
        };
        Thread t1 = new Thread(task ,"Thread 1 ");
        Thread t2 = new Thread(task ,"Thread 2 ");
        
        t1.start();
        t2.start();

    }
    
}
