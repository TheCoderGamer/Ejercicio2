public class Client extends Thread {

    private final String name;
    private final Broker broker;
    private int actions;
    private final int maxBuys = 5;
    private final int minBuys = 1;

    public Client(Broker broker, String name) {
        this.broker = broker;
        this.name = name;
    }

    public void run() {
        try {
            while (true){
                int buys = (int) (Math.random() * (maxBuys - minBuys + 1) + minBuys);
                System.out.printf("Client %s about to buy %d shares%n", name, buys);
                if (broker.buy(buys)) {
                    System.out.printf("Client %s bought %d shares%n", name, buys);
                    actions += buys;
                }
                else {
                    System.out.printf("Client %s couldn't buy %d shares%n", name, buys);
                }
                Thread.sleep((long) (Math.random() * 5000));
            }
        } catch (InterruptedException e) {
            System.out.printf("Client %s bought %d shares in total%n", name, actions);
            return;
        }

    }
}
