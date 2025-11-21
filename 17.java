// Thread using Runnable interface
class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(name + " (Runnable) is running");
        }
    }
}

// Thread using Thread class
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(getName() + " (Thread class) is running");
        }
    }
}

public class MergedThreadProgram {
    public static void main(String[] args) {

        // ---------- Runnable Interface Threads ----------
        Thread t1 = new Thread(new MyRunnable("Thread A"));
        Thread t2 = new Thread(new MyRunnable("Thread B"));
        Thread t3 = new Thread(new MyRunnable("Thread C"));

        // ---------- Thread Class Threads ----------
        MyThread t4 = new MyThread("Thread 1");
        MyThread t5 = new MyThread("Thread 2");
        MyThread t6 = new MyThread("Thread 3");

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        t4.start();
        t5.start();
        t6.start();
    }
}