import java.io.File;

public class EjMetodosFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\21650521\\eclipse-workspace\\Ficheros\\primerFichero.txt");
		//String[] fichero = f.list();
		if(f.exists()) {
			System.out.println("Nombre del fichero "+ f.getName());
			System.out.println("Ruta "+ f.getPath());
			System.out.println("Ruta absoluta "+ f.getAbsolutePath());
			System.out.println("Se puede leer? "+ f.canRead());
			System.out.println("Se puede escribir? "+ f.canWrite());
			System.out.println("Tamaño "+ f.length());
			
			if(f.isDirectory()) {
				System.out.println("Es un directorio");
			}else {
				System.out.println("No es un directorio");
			}
			
			if(f.isFile()) {
				System.out.println("Es un fichero");
			}else {
				System.out.println("No es un fichero");
			}
		}
	}
}
