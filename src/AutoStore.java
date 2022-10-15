import java.util.LinkedList;

public class AutoStore {
    private int cars = 0;
    private int countSales = 0;
    private final static int TIMECHOICECAR = 600;
    private final LinkedList<Integer> listConsumers;

    public AutoStore(LinkedList<Integer> linkedList) {
        this.listConsumers = linkedList;
    }

    public synchronized void get(int idCounsumer) {
        System.out.println("Покупатель" + idCounsumer + " зашел в автосалон");
        try {
            Thread.sleep(TIMECHOICECAR);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.cars < 1) {
            System.out.println("Машин нет");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.cars--;
        this.countSales++;
        System.out.println("Покупатель" + idCounsumer + " уехал на новеньком автор");
        this.listConsumers.add(idCounsumer);
    }

    public synchronized void put() {
        this.cars++;
        System.out.println("Производитель Toyota выпустил 1 авто");
        notify();
    }

    public synchronized int getCountSales() {
        return this.countSales;
    }
}
