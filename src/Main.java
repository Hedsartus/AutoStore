import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> listCostumersId = new LinkedList<>();
        listCostumersId.add(1);
        listCostumersId.add(2);
        listCostumersId.add(3);
        listCostumersId.add(4);
        listCostumersId.add(5);

        AutoStore autoStore = new AutoStore(listCostumersId);
        Thread threadProducer = new Thread(new Producer(autoStore));
        threadProducer.start();

        while (true) {
            if (autoStore.getCountSales() < 10) {
                if (!listCostumersId.isEmpty()) {
                    new Thread(new Consumer(autoStore, listCostumersId.pop())).start();
                }
            } else {
                break;
            }
        }

    }

}
