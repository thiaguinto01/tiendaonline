package tiendaonlinedemo.model.transporte.dtos;

public class DTOVehiculo {

	
	private int codigo;
	private String placa;
	private int anio;
	private String kilometraje;
	private String color;
	
	
	
	
	public DTOVehiculo(int codigo, String placa, int anio, String kilometraje, String color) {
		
		this.codigo = codigo;
		this.placa = placa;
		this.anio = anio;
		this.kilometraje = kilometraje;
		this.color = color;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
