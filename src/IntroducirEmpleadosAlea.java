import java.io.*;

public class IntroducirEmpleadosAlea {
	private final static int TAM_NOMBRE = 10;

	public static void main(String[] args) {		
		
		String[] nombres = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"};
     	int[] departamentos = {10, 20, 30, 20, 10};
     	double[] salarios = {2000.00, 1500.50, 3000.40, 2300.60, 1900.10};     	
     	RandomAccessFile raf = null;
     	
     	try {
			raf = new RandomAccessFile("empleados.dat", "rw");
			
			//nos situamos al final del fichero
		     raf.seek(raf.length());
		    
		     long tam = raf.length();
		     //cada registro ocupa 36 bytes (4 del ID, 20 del nombre, 4 del Dept y 8 del Salario String son 2bytes por cada caracter.
		     
		     tam = tam / 36; //numero de registros
		     
		     /*empezamos a escribir
		     definimos un StringBuffer para almacenar el nombre y que siempre tenga
		     tamaño 10, rellenando con espacios en blanco*/
		     StringBuffer sb = null;
		     for (int i = 0; i < salarios.length; i++) {
		    	
		    	 //id		    	 
		    	 	raf.writeInt((int)tam + i + 1);
		    	 
			 		sb = new StringBuffer(nombres[i]);			 		
			 		sb.setLength(TAM_NOMBRE); 
			 		raf.writeChars(sb.toString());
					// depto
					raf.writeInt(departamentos[i]);
					// salario
					raf.writeDouble(salarios[i]);

		 	 }
			   		//nos situamos al principio
				     raf.seek(0);
				     int id, dept;
				     char[] cNombre = new char[TAM_NOMBRE];
			              String nombre;
				     double salario;

	     	     try {
	     	    	 	while (raf.getFilePointer() <= raf.length()) {
	     	    	 	id = raf.readInt();
	
					     for (int i = 0; i < TAM_NOMBRE; i++) {
						cNombre[i] = raf.readChar();
					     }
					     nombre = new String(cNombre);
					     dept = raf.readInt();
					     salario = raf.readDouble();
					     System.out.println("ID: " + id + " Nombre: " + nombre +
					     " Depto: " + dept + " Salario: " + salario);
	     	    	 }
	     	     
	     	     	}catch(FileNotFoundException e){
	     	     		e.printStackTrace();
	     	     	}catch (EOFException e) {	     	     		
	     	     	}catch(IOException e){
	     	     		e.printStackTrace();
	     	     	}
     				}catch(FileNotFoundException e){
     					e.printStackTrace();
     				}catch(IOException e){
     					e.printStackTrace();
     				}finally{
						if (raf != null) {
							try {
								raf.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
	     	     	}
     			}
			}		