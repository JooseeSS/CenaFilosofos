package cena;

import static org.junit.Assert.*;
import org.junit.Test;

public class MonitorTest {

    @Test
    public void testCicloVida() throws InterruptedException {
        // Creamos un monitor para 5 filósofos
        MonitorFilosofos monitor = new MonitorFilosofos(5);
        int id = 0; // Usaremos al filósofo 0 para la prueba

        // 1. Verificar estado inicial
        assertEquals("Debería empezar PENSANDO", 
                MonitorFilosofos.PENSANDO, monitor.getEstado(id));

        // 2. Simular que toma tenedores
        monitor.tomarTenedores(id);
        assertEquals("Debería estar COMIENDO", 
                MonitorFilosofos.COMIENDO, monitor.getEstado(id));

        // 3. Simular que deja tenedores
        monitor.dejarTenedores(id);
        assertEquals("Debería volver a PENSANDO", 
                MonitorFilosofos.PENSANDO, monitor.getEstado(id));
    }
}