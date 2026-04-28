import java.io.File;
import java.util.Scanner;

public class Traductor {
    
    public void procesarArchivo(String nombreArchivo, Diccionario diccionario) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] palabras = linea.split(" ");
                StringBuilder lineaTraducida = new StringBuilder();

                for (String palabra : palabras) {
                    String palabraLimpia = palabra.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    
                    if (palabraLimpia.isEmpty()) continue;

                    String traduccion = diccionario.translate(palabraLimpia);

                    if (traduccion != null) {
                        lineaTraducida.append(palabra.toLowerCase().replace(palabraLimpia, traduccion)).append(" ");
                    } else {
                        lineaTraducida.append(palabra).append(" ");
                    }
                }
                System.out.println(lineaTraducida.toString().trim());
            }
        } catch (Exception e) {
            System.out.println("Error leyendo el archivo de texto: " + e.getMessage());
        }
    }
}