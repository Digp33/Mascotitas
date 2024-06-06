import java.util.HashMap;

public class ConsultarPaquetes {
    public static void consultarPaquetes(HashMap<String, Double> paquetes) {
        System.out.println("Consulta de paquetes:");
        if (paquetes.isEmpty()) {
            System.out.println("No hay paquetes registrados.");
        } else {
            System.out.println("Lista de paquetes registrados:");
            for (String nombre : paquetes.keySet()) {
                System.out.println(nombre + ": $" + paquetes.get(nombre));
            }
        }
    }
}

