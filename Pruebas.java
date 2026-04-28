import org.junit.Test;
import static org.junit.Assert.*;

public class Pruebas {

    @Test
    public void testInsertarYBuscar() {
        ArbolBinario<Asociacion<String, String>> arbol = new ArbolBinario<>();
        Asociacion<String, String> nuevaAsoc = new Asociacion<>("dog", "perro");
        
        arbol.insert(nuevaAsoc);
        assertFalse("El árbol no debería estar vacío después de insertar", arbol.isEmpty());
        
        Asociacion<String, String> llaveBusqueda = new Asociacion<>("dog", null);
        Asociacion<String, String> resultado = arbol.search(llaveBusqueda);
        
        assertNotNull("El elemento debería ser encontrado en el árbol", resultado);
        assertEquals("La traducción de 'dog' debe ser 'perro'", "perro", resultado.getValue());
    }
}