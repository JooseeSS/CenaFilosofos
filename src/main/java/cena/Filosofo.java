package cena;

import java.util.Random;

public class Filosofo implements Runnable {
    private final int id;
    private final MonitorFilosofos monitor;
    private final Random random = new Random();

    public Filosofo(int id, MonitorFilosofos monitor) {
        this.id = id;
        this.monitor = monitor;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " PENSANDO.");
        Thread.sleep(random.nextInt(1000) + 500); 
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " COMIENDO 🍝");
        Thread.sleep(random.nextInt(1000) + 500);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                pensar();
                System.out.println("Filósofo " + id + " HAMBRIENTO.");
                monitor.tomarTenedores(id);
                comer();
                monitor.dejarTenedores(id);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}