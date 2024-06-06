package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistroAdopciones {

    private Map<Cliente, Mascota> adopciones;
    private ArrayList<Mascota> mascotasDisponibles;

    public RegistroAdopciones() {

        adopciones = new HashMap<>();
        mascotasDisponibles = new ArrayList<>();
    }

    public void agregarMascotaDisponible(Mascota mascota) {

        mascotasDisponibles.add(mascota);
    }

    public void adoptarMascota(Cliente cliente, Mascota mascota) throws Exception {

            if (mascota.getVacunas() == null || mascota.getVacunas().isEmpty()) {

            throw new Exception("No tiene vacunas suministradas");
        }

        if (mascotasDisponibles.contains(mascota)) {

            adopciones.put(cliente, mascota);
            mascotasDisponibles.remove(mascota);
            System.out.println("El registro de adopcion ha sido exitoso");

        } else {

            System.out.println("La mascota no está disponible para adopción");
        }
    }

    public void devolverMascota(Cliente cliente, boolean maltrato) {

        Mascota mascota = adopciones.get(cliente);

        if (mascota != null) {

            if (maltrato) {
                
                System.out.println("Se ha cobrado una multa por maltrato");
               
            }

            adopciones.remove(cliente);
            mascotasDisponibles.add(mascota);
            System.out.println("Mascota devuelta exitosamente");

        } else {

            System.out.println("El cliente no tiene ninguna mascota adoptada");
        }
    }

    public void mostrarMascotasDisponibles() {

        if (mascotasDisponibles.isEmpty()) {

            System.out.println("No hay mascotas disponibles para adopción");
            return;
        }

        for (Mascota mascota : mascotasDisponibles) {

            System.out.println("Número de Mascota: " + mascota.getNumeroMascota());
            System.out.println("Nombre: " + mascota.getNombre());
            System.out.println("Raza: " + mascota.getRaza());
            System.out.println("Vacunas: " + mascota.getVacunas());
        
        }
    }

    public void mostrarAdopciones() {

        if (adopciones.isEmpty()) {

            System.out.println("No hay adopciones registradas");
            return;
        }

        for (Map.Entry<Cliente, Mascota> entry : adopciones.entrySet()) {

            Cliente cliente = entry.getKey();
            Mascota mascota = entry.getValue();
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Número de Mascota: " + mascota.getNumeroMascota());
            System.out.println("Nombre de Mascota: " + mascota.getNombre());
            System.out.println("Raza: " + mascota.getRaza());
            System.out.println("Vacunas: " + mascota.getVacunas());
        
        }
    }

}