package BinariosEnData;
import java.io.*;

public class EscribeFichBinData {

	public static void main(String[] args) {
		
		DataOutputStream dos = null;
		
		try {
			dos = new DataOutputStream(new FileOutputStream("clase.dat"));
			
			String[] nombres = { "Juan", "Miguel", "Carlos", "Javier", "Pedro"};
			int[] edades = { 20, 19, 22, 23, 19};
			
			for (int i = 0; i < edades.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(dos !=null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}