public class Main {
    //todo: interrupt thread when user wants
    public static void main(String[] args) {
        Thread firstThread = new Thread(new MyThread());
        Thread secondThread = new Thread(new MyThread());
        System.out.print(ThreadLister.allThreadsToString());
        firstThread.start();
        secondThread.start();
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
           System.out.print("asd");

        }
    }
}
