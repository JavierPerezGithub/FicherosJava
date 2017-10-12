package practicaPDF;

import java.io.Serializable;

public class Producto implements Serializable {

	private int id;
	private String nombre, medidas;
	private float precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Producto(int id, String nombre, String medidas, float precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.medidas = medidas;
		this.precio = precio;
	}

	public Producto() {
		super();
	}
}
