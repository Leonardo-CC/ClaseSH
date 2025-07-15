package hilos;

// Clase que contiene el recurso compartido
class Contador {
    private int count = 0;

    // Método sincronizado para incrementar de forma segura
    public synchronized void incrementar() {
        count++;
    };

    public int getCount() {
        return count;
    }
}
