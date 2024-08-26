package uniandes.dpoo.estructuras.logica;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;
    	
    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     * Es el Metodo Constructor 
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    
    	int[] copia_enteros = Arrays.copyOf(this.arregloEnteros, this.arregloEnteros.length);  
    			return copia_enteros; 
    			
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copia_cadenas = Arrays.copyOf(this.arregloCadenas , this.arregloCadenas.length);
    	
    	return copia_cadenas;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
    	int cantidad_enteros = arregloEnteros.length;
        return cantidad_enteros;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
    	int cantidad_cadenas = arregloCadenas.length;
        return cantidad_cadenas
    	;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero(int EnteroAgregar)
    {
    	int nuevoTamaño = this.arregloEnteros.length + 1;
        this.arregloEnteros = Arrays.copyOf(this.arregloEnteros, nuevoTamaño);
        arregloEnteros[nuevoTamaño - 1] = EnteroAgregar;
       
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadenaAgregar )
    {
    	int nuevoTamaño = this.arregloCadenas.length + 1;
        this.arregloCadenas = Arrays.copyOf(this.arregloCadenas, nuevoTamaño);
        arregloCadenas[nuevoTamaño - 1] = cadenaAgregar;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
        int count = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] == valor) {
                count++;
            }
        }
       
        // Creo un nuevo arreglo con un tamaño menor
        int[] nuevoArreglo = new int[this.arregloEnteros.length - count];
        //creo un indice para aplicarlo a el nuevo arreglo
        int index = 0;
        
        //Ahora agrego todos los enteros que no sean el valor que me dieron por parametro
        for (int ii = 0; ii < this.arregloEnteros.length; ii++) {
            if (this.arregloEnteros[ii] != valor) {
                nuevoArreglo[index++] = this.arregloEnteros[ii];
            }
        }
        
        //Remplazo el arreglo original con el nuevo arreglo
        this.arregloEnteros = nuevoArreglo;
    }
    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadenaEliminar )
    {
    	int count = 0;
        for (int i = 0; i < this.arregloCadenas.length; i++) {
            if (this.arregloCadenas[i] == cadenaEliminar) {
                count++;
            }
        }
       
        // Creo un nuevo arreglo con un tamaño menor
        String[] nuevoArreglo = new String[this.arregloCadenas.length - count];
        //creo un indice para aplicarlo a el nuevo arreglo
        int index = 0;
        
        //Ahora agrego todos las cadenas que no sean las que me dieron por parametro
        for (int ii = 0; ii < this.arregloCadenas.length; ii++) {
            if (this.arregloCadenas[ii] != cadenaEliminar) {
                nuevoArreglo[index++] = this.arregloCadenas[ii];
            }
        }
        
        //Remplazo el arreglo original con el nuevo arreglo
        this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (posicion > this.arregloEnteros.length) {
            posicion = this.arregloEnteros.length;
        } else if (posicion < 0) {
            posicion = 0;
        }

        int[] nuevoArreglo = new int[this.arregloEnteros.length + 1];
        int j = 0;

        for (int i = 0; i < nuevoArreglo.length; i++) {
            if (i == posicion) {
                nuevoArreglo[i] = entero;
            } else {
                nuevoArreglo[i] = this.arregloEnteros[j];
                j++;
            }
        }
        
        this.arregloEnteros = nuevoArreglo; 
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if(posicion>=0 && posicion<this.arregloEnteros.length) {
    		 int[] control = new int[this.arregloEnteros.length-1];
    		 
    		 int index = 0;
    		 for(int entero:this.arregloEnteros) {
    			 if (index ==posicion) {
    				 continue;	  
    			 }
    			 else {
    				 control[index]= entero;
    				 index++;
    			 }
    		 }
    		 
    	 }
        
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros(double[] valores) {
        int[] newArreglo = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            newArreglo[i] = (int) Math.round(valores[i]);
        }
        this.arregloEnteros = newArreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] newArreglo = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            newArreglo[i] = objetos[i].toString();
        }
        this.arregloCadenas = newArreglo;
    }
    

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] < 0) {
            	this.arregloEnteros[i] = this.arregloEnteros[i] * -1;
            }
        }
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(this.arregloEnteros);
    	
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(this.arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int count = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] == valor) {
                count++;
            }
            
        }
        return count;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int count = 0;
        String cadenaMinuscula = cadena.toLowerCase(); // Convertimos la cadena a buscar a minúsculas

        for (int i = 0; i < this.arregloCadenas.length; i++) {
            if (this.arregloCadenas[i].toLowerCase().equals(cadenaMinuscula)) {
                count++;
            }
        }

        return count;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int [] control = getCopiaEnteros();
    	
    	int a = contarApariciones(valor);
        
        int[] respuesta = new int[a];
        
        int x = 0;
        this.arregloEnteros=control;
        for(int i =0;i<this.arregloEnteros.length;i++) {
            if (arregloEnteros[i] == valor) {
                respuesta[x] = i; 
                x++;
            }  
        }
        return respuesta;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	// Caso base
        if (arregloEnteros.length == 0) {
            return new int[0];
        }
        // variables
        int minimo = arregloEnteros[0];
        int maximo = arregloEnteros[0];
        // ciclo
        for (int Entero:this.arregloEnteros) {
            if (Entero < minimo) {
                minimo = Entero;
            } else if (Entero > maximo) {
                maximo = Entero;
            }
        }
        int[] rango = new int[2];
        rango[0] = minimo;
        rango[1] = maximo;

        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();

        for (int numero : arregloEnteros) {
            histograma.put(numero, histograma.getOrDefault(numero, 0) + 1);
        }

        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteros diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	int cantidad = 0;
    	int[] control = getCopiaEnteros();
    	while(this.arregloEnteros.length!=0) {
    		int x = contarApariciones(this.arregloEnteros[0]);
    		if(x>1) {
    			cantidad++;
    		}
    		eliminarEntero(this.arregloEnteros[0]);
    	}
    	this.arregloEnteros=control;
        return cantidad;
        }

     

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {	
        if (otroArreglo.length != this.arregloEnteros.length) {
            return false;
        }  
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (otroArreglo[i] != this.arregloEnteros[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
        if (otroArreglo.length != this.arregloEnteros.length) {
            return false;
        }
        int[] copia1 = Arrays.copyOf(this.arregloEnteros, this.arregloEnteros.length);
        int[] copia2 = Arrays.copyOf(otroArreglo, otroArreglo.length);

        
        Arrays.sort(copia1);
        Arrays.sort(copia2);
        
        for (int i = 0; i < copia1.length; i++) {
            if (copia1[i] != copia2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
	    	
	    if (cantidad <= 0) {
	        System.out.println("La cantidad de elementos debe ser positiva.");
	        return;
	    }
	
	    if (minimo >= maximo) {
	        System.out.println("El mínimo debe ser menor que el máximo.");
	        return;
	    }
	
	    
	    arregloEnteros = new int[cantidad];
	
	    for (int i = 0; i < cantidad; i++) {
	        int numeroAleatorio = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
	        arregloEnteros[i] = numeroAleatorio;
	    }
    }

    
    
    
    
}
