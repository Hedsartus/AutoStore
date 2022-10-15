public class Producer implements Runnable {
    private final static int PRODUCTIONTIME = 1000;
    private final AutoStore autoStore;

    public Producer(AutoStore autoStore) {
        this.autoStore = autoStore;
    }

    @Override
    public void run() {
        while (autoStore.getCountSales() < 10) {
            try {
                Thread.sleep(PRODUCTIONTIME);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            this.autoStore.put();
        }
    }
}
