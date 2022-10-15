public class Consumer implements Runnable {
    private final AutoStore autoStore;
    private final int id;

    public Consumer(AutoStore autoStore, int id) {
        this.autoStore = autoStore;
        this.id = id;
    }

    @Override
    public void run() {
        autoStore.get(id);
    }
}
