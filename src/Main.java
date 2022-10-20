import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Broker broker = new Broker(20);

        Client[] clients = new Client[4];

        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Client(broker, "Client " + i);
            clients[i].start();
        }

        broker.waitUntilNoSharesAvailable();

        for (Client c : clients){
            c.interrupt();
        }
    }
}
