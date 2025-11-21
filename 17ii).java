class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for(int i=0; i<5; i++) {
            System.out.println(getName() + " is running");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread 1");
        MyThread t2 = new MyThread("Thread 2");
        MyThread t3 = new MyThread("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}