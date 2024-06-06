package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroCitas {

    private ArrayList<Cita> citas;

    public RegistroCitas() { citas = new ArrayList<>(); }

    public void registroCitas(Cita nuevaCita) {

        for (Cita cita : citas) {

            if (cita.ocupado(nuevaCita.getFecha(), nuevaCita.getHora())) {

                System.out.println("Error: Ya hay una cita programada para esa fecha y hora.");
                return;
            }
        }

        citas.add(nuevaCita);
        System.out.println("Cita registrada exitosamente.");
    }

    public void registrarNuevaCita(Scanner scanner) {
        
        System.out.print("Número de Cita: ");
        int numCita = scanner.nextInt();
        scanner.nextLine();  

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        System.out.print("Hora (HH:MM): ");
        String horaStr = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaStr);

        System.out.print("Veterinario (Nombre): ");
        String nombreVet = scanner.nextLine();
        Veterinario vet = new Veterinario(nombreVet);  
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        System.out.print("Paquetes (Nombre): ");
        String nombrePaquete = scanner.nextLine();
        Paquete paquete = new Paquete(nombrePaquete); 

        Cita nuevaCita = new Cita(numCita, fecha, hora, vet, descripcion, paquete);
        registroCitas(nuevaCita);
    }

    public void mostrarCitas() {

        for (Cita cita : citas) {

            System.out.println("Número de Cita: " + cita.getNumCita());
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());
            System.out.println("Veterinario: " + cita.getVet().getNombre());  
            System.out.println("Descripción: " + cita.getDescripcion());
            System.out.println("Paquetes: " + cita.getPaquetes().getNombre());  
            
        }
    }

}
