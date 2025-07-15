package hilos;

// Hilo que incrementa el contador
public class ContadorThread extends Thread {
    private Contador contador;

    public ContadorThread(Contador contador) {
        this.contador = contador;
    }

    @Override public void run() {
        System.out.println("Hilo iniciado");
        for (int i = 0; i < 1000; i++) {
            contador.incrementar();
        }
    }
}
