/**

 * @author: Nadya Cristina Sosa Santiago, González Portilla Daniel Iram, Ada Paulina Santillan Osorio, Alexis Ivan Santiago Avila

 * @version: 05/06/2024/A

 */

import java.util.HashMap;
import java.util.Scanner;

public class AltaPaquetes {
    static HashMap<String, Double> paquetes = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Alta de paquetes veterinario (Escribe 'fin' para terminar).");

        while (true) {
            System.out.print("Ingrese el nombre del paquete: ");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.print("Ingrese el precio del paquete: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer del scanner

            paquetes.put(nombre, precio);
            System.out.println("Paquete '" + nombre + "' agregado correctamente.");
        }

        // Llama al método para consultar los paquetes registrados
        ConsultarPaquetes.consultarPaquetes(paquetes);
    }
}

