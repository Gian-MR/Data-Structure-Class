package Exam_3.Mock;

import java.util.LinkedList;
import java.util.Queue;

public class Bandeja_Notificaciones {
    static class BandejaVaciaException extends Exception {
        public BandejaVaciaException(String mensaje) {
            super(mensaje);
        }
    }

    private final Queue<String> notificacionesPendientes = new LinkedList<>();
    private final Queue<Integer> ultimosConteos = new LinkedList<>();
    private final int ventana = 4;
    private int sumaConteos = 0;

    public Bandeja_Notificaciones() {
        notificacionesPendientes.offer("Tienes un nuevo mensaje");
        notificacionesPendientes.offer("Tu pedido fue enviado");
        notificacionesPendientes.offer("Recordatorio de reunion");
        notificacionesPendientes.offer("Actualizacion disponible");
    }

    // notificar <mensaje>
    public void notificar(String mensaje) {
        notificacionesPendientes.offer(mensaje);
        System.out.println("Notificacion encolada: " + mensaje);
    }

    // leer
    public String leer() throws BandejaVaciaException {
        String siguiente = notificacionesPendientes.poll();
        if (siguiente == null) {
            throw new BandejaVaciaException("No hay notificaciones pendientes");
        }
        System.out.println("Leida: " + siguiente);
        return siguiente;
    }

    // ver siguiente
    public String verSiguiente() {
        String siguiente = notificacionesPendientes.peek();
        if (siguiente == null) {
            System.out.println("No hay notificaciones pendientes");
            return null;
        }
        System.out.println("Siguiente: " + siguiente);
        return siguiente;
    }

    // promedio movil de los ultimos 4 conteos recibidos
    public double registrarConteoRecibido(int conteo) {
        ultimosConteos.offer(conteo);
        sumaConteos += conteo;

        if (ultimosConteos.size() > ventana) {
            sumaConteos -= ultimosConteos.poll();
        }

        double promedio = (double) sumaConteos / ultimosConteos.size();
        System.out.println("Promedio movil actual (ultimos " + ultimosConteos.size() + "): " + promedio);
        return promedio;
    }

    public static void main(String[] args) {
        Bandeja_Notificaciones bandeja = new Bandeja_Notificaciones();

        bandeja.verSiguiente();
        bandeja.notificar("Te mencionaron en un comentario");

        try {
            bandeja.leer();
            bandeja.leer();
            bandeja.leer();
            bandeja.leer();
            bandeja.leer();
        } catch (BandejaVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (int conteo : new int[] {5, 7, 3, 9, 10, 6}) {
            bandeja.registrarConteoRecibido(conteo);
        }
    }
}
