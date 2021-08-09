package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trans_vehiculo database table.
 * 
 */
@Entity
@Table(name="trans_vehiculo")
@NamedQuery(name="TransVehiculo.findAll", query="SELECT t FROM TransVehiculo t")
public class TransVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trans_vehiculo", unique=true, nullable=false)
	private Integer idTransVehiculo;

	@Column(nullable=false)
	private Integer anio;

	@Column(nullable=false, length=15)
	private String color;

	@Column(nullable=false, length=15)
	private String kilometraje;

	@Column(nullable=false, length=7)
	private String placa;

	//bi-directional many-to-one association to SegUsuario
	@ManyToOne
	@JoinColumn(name="id_seg_usuario")
	private SegUsuario segUsuario;

	public TransVehiculo() {
	}

	public Integer getIdTransVehiculo() {
		return this.idTransVehiculo;
	}

	public void setIdTransVehiculo(Integer idTransVehiculo) {
		this.idTransVehiculo = idTransVehiculo;
	}

	public Integer getAnio() {
		return this.anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public SegUsuario getSegUsuario() {
		return this.segUsuario;
	}

	public void setSegUsuario(SegUsuario segUsuario) {
		this.segUsuario = segUsuario;
	}

}