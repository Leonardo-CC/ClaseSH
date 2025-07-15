package hilos;

public class PruebaContador {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread t1 = new ContadorThread(contador);
        Thread t2 = new ContadorThread(contador);
        Thread t3 = new ContadorThread(contador);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Conteo final: " + contador.getCount()); // Debe ser 3000
    }
}
