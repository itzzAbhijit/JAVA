class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(name + " is running");
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable("Thread A"));
        Thread t2 = new Thread(new MyRunnable("Thread B"));
        Thread t3 = new Thread(new MyRunnable("Thread C"));

        t1.start();
        t2.start();
        t3.start();
    }
}