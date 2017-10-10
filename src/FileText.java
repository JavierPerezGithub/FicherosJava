import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = "C:\\Users\\21650521\\eclipse-workspace\\Ficheros\\fichero1.txt";
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader(nombre);
			fw = new FileWriter(nombre);
			
			//Escribimos en el fichero un String y un caracter 97 (a)
			fw.write("Esto es una prueb");
			fw.write(97);
			
			//Con el flush confirmamos los datos que estamos transfiriendo.
			fw.flush();
			
			//Leemos el fichero y lo mostramos por pantalla
	        int valor=fr.read();
	        
	        //Lo que recoge valor es el codigo ascii de la primera letra en cada vuelta.
	        while(valor!=-1){
	        	
	            System.out.print((char)valor);
	            valor=fr.read();
	        }
	        
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no ha sido encontrado");
		} catch (IOException e) {
			System.out.println("Error IO: "+ e.getMessage());
		} finally {
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}