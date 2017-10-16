package ficherosTexto;
import java.io.*;

public class EscrituraFichTextBuf {

	public static void main(String[] args) {
		
		//String nombre = "C:\\Users\\21650521\\eclipse-workspace\\Ficheros\\fichero3.txt";		
		BufferedWriter bw = null;
		String[] lineas = { "Linea 1 ", "Linea 2 ", "Linea 3 ", "Linea 4 ", "Linea 5 ", "Linea 6 "};

		try {
			//PARA NO MACHACAR LO QUE TENGAMOS EN EL FICHERO HAY QUE AÑADIR TRUE
			bw = new BufferedWriter(new FileWriter("prueba.txt", true));
			for (int i = 0; i < lineas.length; i++) {
				
				bw.write(lineas[i]);
				bw.newLine();				
			}
			
		} catch (IOException e) {
			System.out.println("Error IO: "+e.getMessage());
		}finally {
			if(bw!=null) {
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("Error IO: "+e.getMessage());
				}
			}
		}
	}

}
