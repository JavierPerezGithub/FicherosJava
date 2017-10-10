import java.io.*;

public class CopiaFicherosBin {

	public static void main(String[] args) {
		
		// Sirve para crear un flujo de entrada y salida
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
              		
		// Entrada y salida definida
		try {
			bis = new BufferedInputStream(new FileInputStream(
					"C:\\Users\\21650521\\eclipse-workspace\\"
			+"Ficheros\\bin\\CopiaFicherosBin.class"));
			bos = new BufferedOutputStream(new FileOutputStream(
					"CopiaFicheroBin.class"));
			
			//creamos un array de bytes para la lectura
			byte [] array = new byte[1000];
			
			//utilizamos el metodo read para leer volcando lo que lean en el array de bytes
			int leidos = bis.read(array);
			while (leidos > 0) {
			
			//la estructura del write es donde escribe, inicio y fin
				bos.write(array,0,leidos);
				leidos = bis.read(array);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//codigo para cerrar el flujo
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			//fin del código para cerrar el flujo
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

}
