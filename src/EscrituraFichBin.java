import java.io.*;

public class EscrituraFichBin {

	public static void main(String[] args) {
		File fich = new File("fichero.dat");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(fich);
			fos = new FileOutputStream(fich, true);
			
			for (int i = 0; i < 100; i++) {
				fos.write(i);				
			}
			fos.flush();
			
			int n=0;
			while((n = fis.read()) != -1) {
				System.out.println(n);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					System.out.println("Error IO: "+ e.getMessage());
				}
			}
		}
	}
}