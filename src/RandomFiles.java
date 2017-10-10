import java.io.*;
import java.util.Scanner;

public class RandomFiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce un entero: ");
		int num=Integer.parseInt(sc.nextLine());
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("enteros.dat", "rw");
			//nos posicionamos al final del fichero
			raf.seek(raf.length());
			//se escribe el entero
			raf.writeInt(num);
			//nos colocamos al principio y leemos todo el contenido del fichero.
			raf.seek(0);
			System.out.println("El contenido del fichero es el siguiente");
			int nLeido;
			while(true) {
				nLeido=raf.readInt();
				System.out.println(nLeido);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		} catch (EOFException e) {
			System.out.println("Fichero finalizado");
		}catch (IOException e) {
			System.out.println("Error de entrada o salida");
		}finally {
			sc.close();
			if(raf!=null) {
				try {
					raf.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}			
		}		
	}
}