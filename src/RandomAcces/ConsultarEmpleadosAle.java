package RandomAcces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ConsultarEmpleadosAle {

	private static int TAM_REGISTRO = 36;
	// BYTES 4 del id(int), 20 del nombre(10 caracteres), 4 del depto(int) y 8 del
	// salario(double)
	private static int TAM_NOMBRE = 10; // caracteres que tiene el nombre

	public static void main(String[] args) {
		RandomAccessFile raf = null;
		Scanner sc = new Scanner(System.in);

		try {
			raf = new RandomAccessFile("empleados.dat", "r");

			System.out.println("Introduce el id del empleado que desea consultar: ");
			int id = Integer.parseInt(sc.nextLine());

			int pos = (id - 1) * TAM_REGISTRO;

			// comprobamos que es correcta
			if (pos < raf.length()) {
				// procedemos a la lectura
				// lo primero es posicionarse con el método seek
				raf.seek(pos);
				// primero leemos el id
				id = raf.readInt();
				// segundo leemos el nombre y necesito leerlo caracter a caracter y para eso uso
				// un array de caracteres
				char[] cNombre = new char[TAM_NOMBRE];
				// relleno con un bucle
				for (int i = 0; i < cNombre.length; i++) {
					cNombre[i] = raf.readChar();
				}
				// creamos un String para pasarle el array de caracteres
				String nombre = new String(cNombre);

				// tercero el departamento
				int depto = raf.readInt();

				// leemos el salario
				double salario = raf.readDouble();
				System.out.println("ID: " + id + " Nombre: " + nombre + " Depto: " + depto + " Salario: " + salario);

			} else {
				System.out.println("No existe ningún empleado con ese id");
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			sc.close();
		}
	}

}
