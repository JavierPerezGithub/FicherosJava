package practicaPDF;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ejercicio1 /*insertarProductos*/{

	public static void main(String[] args) {
		/*
		 * Crea una clase Producto en el proyecto con los siguientes 
		 * atributos: id (int), nombre (String), medidas (String), precio (float). 
		 * Crea también sus constructores, getters y setters. Ten en cuenta 
		 * que objetos de esta clase serán almacenados en ficheros binarios.
		 * Crea una clase InsertarProductos que mediante un array de objetos 
		 * Producto introduzca 10 productos en un fichero binario productos.dat. 
		 * Almacena el fichero dentro de la carpeta del proyecto. 
		 */
		Producto [] prod = new Producto[9];
		prod[0]= new Producto(1, "prod1", "12cm", 30);
		prod[1]= new Producto(2, "prod2", "13cm", 40);
		prod[2]= new Producto(3, "prod3", "14cm", 50);
		prod[3]= new Producto(4, "prod4", "15cm", 60);
		prod[4]= new Producto(5, "prod5", "16cm", 70);
		prod[5]= new Producto(6, "prod6", "17cm", 80);
		prod[6]= new Producto(7, "prod7", "18cm", 90);
		prod[7]= new Producto(8, "prod8", "19cm", 10);
		prod[8]= new Producto(9, "prod9", "20cm", 20);
		prod[9]= new Producto(10, "prod10", "21cm", 130);
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("escriboProductos.dat"));
			oos.writeObject(prod);
			oos.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

