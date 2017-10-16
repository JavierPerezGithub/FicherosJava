package ficherosTexto;
import java.io.*;

public class LeerFichTextBuf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String nombre = "C:\\Users\\21650521\\eclipse-workspace\\Ficheros\\fichero2.txt";
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader("prueba.txt"));
			
			String linea = null;
			//En cada iteracion le decimos al while lo que tiene que ir mostrando mientras no se cumpla la condicion
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no ha sido encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error IO: "+ e.getMessage());
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}