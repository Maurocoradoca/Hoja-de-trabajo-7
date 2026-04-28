public class Main {
    public static void main(String[] args) {
        Diccionario miDiccionario = new Diccionario(); 
        miDiccionario.loadFromFile("Palabras.txt"); 
        miDiccionario.printInOrder();   
        System.out.println("\nTraducción del Archivo");
        Traductor traductor = new Traductor();
        traductor.procesarArchivo("Texto.txt", miDiccionario); 
    }
}