import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LecturaFichBinObj {

	public static void main(String[] args) {
		//declaramos el stream de entrada
		ObjectInputStream ois = null;
		
		//abrimos un try para controlar las excepciones
		try {
			//instanciamos el stream de entrada apuntando al fichero binario alumnos.dat
			ois = new ObjectInputStream(new FileInputStream("alumnos.dat"));
			
			//Creamos un objeto persona y le asignamos el valor del primer objeto leido realizando un casteo.
			Persona p = (Persona) ois.readObject();	
			
			//Mientras el objeto sea distinto de null entramos en el bucle
			while (p !=null) {
				//Mostramos por consola los valores de los atributos del objeto del tipo Persona
				System.out.println("Nombre: "+p.getNombre() + " Edad: "+ p.getEdad());
				//leemos el siguiente objeto
				p = (Persona)ois.readObject();
			} 
			
//			while (p=(Persona) ois.readObject() !=null) {
//				System.out.println("Nombre: "+p.getNombre() + " Edad: "+ p.getEdad());
//			}			
			//BLOQUES CATCH
			//Controlamos las posibles excepciones que se pueden producir en el código.
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
		}
		//se ha terminado de leer
		catch (EOFException e) {
			//entrada y salida
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {//BLOQUE finally que siempre se ejecuta
			// si se ha creado el stream
			if(ois !=null) {
				try {
					//lo cerramos.
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
