import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Diccionario {

    private ArbolBinario<Asociacion<String, String>> tree;

    public Diccionario() {
        tree = new ArbolBinario<>();
    }

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.startsWith("(") && line.endsWith(")")) {
                    line = line.substring(1, line.length() - 1);
                }

                int commaIndex = line.indexOf(",");
                if (commaIndex == -1) continue;

                String english = line.substring(0, commaIndex).trim().toLowerCase();
                String spanish  = line.substring(commaIndex + 1).trim();

                Asociacion<String, String> assoc = new Asociacion<>(english, spanish);
                tree.insert(assoc);
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo: " + filename);
            e.printStackTrace();
        }
    }

    public void printInOrder() {
        System.out.println("Diccionario");
        tree.inOrder();
    }

    public String translate(String englishWord) {
        Asociacion<String, String> key = new Asociacion<>(englishWord.toLowerCase(), null);
        Asociacion<String, String> result = tree.search(key);

        if (result != null) {
            return result.getValue();
        }
        return null;
    }
}