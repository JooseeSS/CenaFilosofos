package cena;

public class MonitorFilosofos {

    public static final int PENSANDO = 0;
    public static final int HAMBRIENTO = 1;
    public static final int COMIENDO = 2;

    private final int numFilosofos;
    private final int[] estado;

    public MonitorFilosofos(int numFilosofos) {
        this.numFilosofos = numFilosofos;
        this.estado = new int[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            estado[i] = PENSANDO;
        }
    }

    private int izquierda(int i) {
        return (i + numFilosofos - 1) % numFilosofos;
    }

    private int derecha(int i) {
        return (i + 1) % numFilosofos;
    }

    private void probar(int i) {
        if (estado[i] == HAMBRIENTO &&
            estado[izquierda(i)] != COMIENDO &&
            estado[derecha(i)] != COMIENDO) {
            
            estado[i] = COMIENDO;
            notifyAll();
        }
    }

    public synchronized void tomarTenedores(int i) throws InterruptedException {
        estado[i] = HAMBRIENTO;
        probar(i);
        while (estado[i] != COMIENDO) {
            wait();
        }
    }

    public synchronized void dejarTenedores(int i) {
        estado[i] = PENSANDO;
        probar(izquierda(i));
        probar(derecha(i));
    }
    
    public synchronized int getEstado(int i) {
        return estado[i];
    }
}