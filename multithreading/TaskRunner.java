package multithreading;

public class TaskRunner {

    private static int number = 30;
    private volatile static boolean ready = false;

    private static class Reader extends Thread {

        @Override
        public void run() {
        	System.out.println(ready);
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            while (!ready) {
                Thread.yield();
            }
              System.out.println(ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new Reader().start();
       // Thread.sleep(5000);
        
        try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        number = 42;
        ready = true;
    }
}