package cena;

public class CenaFilosofos {
    public static void main(String[] args) {
        int N = 5;
        MonitorFilosofos monitor = new MonitorFilosofos(N);
        
        System.out.println("Iniciando la cena...");
        
        for (int i = 0; i < N; i++) {
            new Thread(new Filosofo(i, monitor), "Filosofo-" + i).start();
        }
    }
}