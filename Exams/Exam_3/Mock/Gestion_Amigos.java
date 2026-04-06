package Exam_3.Mock;

import java.util.*;

public class Gestion_Amigos {
    Set<String> amigosUsuarioA = new HashSet<>(List.of("Ana", "Carlos", "Diego", "Elena", "Felipe", "Gisele", "Hugo", "Iris"));
    Set<String> amigosUsuarioB = new HashSet<>(List.of("Carlos", "Diego", "Elena", "Juliana", "Kevin", "Laura", "Mateo", "Natalia"));
    Set<String> bloqueados = new HashSet<>(List.of("Bloqueado1", "Bloqueado2"));
    Set<String> seguidores = new HashSet<>(List.of("Seguidor1", "Seguidor2", "Seguidor3", "Seguidor4"));

    public void amigosEnComun() {
        Set<String> comunes = new HashSet<>(amigosUsuarioA);
        comunes.retainAll(amigosUsuarioB);
        System.out.println("Amigos en común: " + comunes);
    }

    public void amigosAnoEnB() {
        Set<String> soloA = new HashSet<>(amigosUsuarioA);
        soloA.removeAll(amigosUsuarioB);
        System.out.println("Amigos de A que NO son de B: " + soloA);
    }

    public void redUnificada() {
        Set<String> unifiedNetwork = new HashSet<>(amigosUsuarioA);
        unifiedNetwork.addAll(amigosUsuarioB);
        System.out.println("Red unificada (A + B): " + unifiedNetwork);
        System.out.println("Total sin duplicados: " + unifiedNetwork.size());
    }

    public void agregarAmigo(String nombre) {
        if (bloqueados.contains(nombre)) {
            System.out.println("Error: " + nombre + " está bloqueado");
            return;
        }
        amigosUsuarioA.add(nombre);
        System.out.println(nombre + " agregado como amigo");
    }

    public static void main(String[] args) {
        Gestion_Amigos gestion = new Gestion_Amigos();
        
        gestion.amigosEnComun();
        gestion.amigosAnoEnB();
        gestion.redUnificada();
        
        System.out.println("\nIntentando agregar amigos:");
        gestion.agregarAmigo("Nuevo");
        gestion.agregarAmigo("Bloqueado1");
    }
}
