public class Broker {
    private int actions;

    public Broker(int max){
        actions = max;
    }

    public synchronized boolean buy(int count){
        System.out.printf("Broker: there's %d available shares%n", actions);
        if (actions-count+1 <= 0){
            return false;
        }
        else {
            actions -= count;
            System.out.printf("Broker: now there's %d available shares%n", actions);
            notifyAll();
            return true;
        }
    }

    public synchronized void waitUntilNoSharesAvailable(){
        while (true){
            if (actions == 0){
                return;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
