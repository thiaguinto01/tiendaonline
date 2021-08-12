package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cli_cliente database table.
 * 
 */
@Entity
@Table(name="cli_cliente")
@NamedQuery(name="CliCliente.findAll", query="SELECT c FROM CliCliente c")
public class CliCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente", unique=true, nullable=false)
	private Integer idCliente;

	@Column(name="cli_activo", nullable=false)
	private Boolean cliActivo;

	@Column(name="cli_cedula", nullable=false, length=10)
	private String cliCedula;

	@Column(name="cli_correo", nullable=false, length=50)
	private String cliCorreo;

	@Column(name="cli_nombre", nullable=false, length=30)
	private String cliNombre;

	//bi-directional many-to-one association to CliContacto
	@ManyToOne
	@JoinColumn(name="id_num_telefono")
	private CliContacto cliContacto;

	//bi-directional many-to-one association to CliDireccion
	@ManyToOne
	@JoinColumn(name="id_direccion")
	private CliDireccion cliDireccion;

	//bi-directional many-to-one association to CliPago
	@ManyToOne
	@JoinColumn(name="id_pago")
	private CliPago cliPago;

	//bi-directional many-to-one association to VenCabecera
	@OneToMany(mappedBy="cliCliente")
	private List<VenCabecera> venCabeceras;

	public CliCliente() {
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Boolean getCliActivo() {
		return this.cliActivo;
	}

	public void setCliActivo(Boolean cliActivo) {
		this.cliActivo = cliActivo;
	}

	public String getCliCedula() {
		return this.cliCedula;
	}

	public void setCliCedula(String cliCedula) {
		this.cliCedula = cliCedula;
	}

	public String getCliCorreo() {
		return this.cliCorreo;
	}

	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}

	public String getCliNombre() {
		return this.cliNombre;
	}

	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}

	public CliContacto getCliContacto() {
		return this.cliContacto;
	}

	public void setCliContacto(CliContacto cliContacto) {
		this.cliContacto = cliContacto;
	}

	public CliDireccion getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(CliDireccion cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public CliPago getCliPago() {
		return this.cliPago;
	}

	public void setCliPago(CliPago cliPago) {
		this.cliPago = cliPago;
	}

	public List<VenCabecera> getVenCabeceras() {
		return this.venCabeceras;
	}

	public void setVenCabeceras(List<VenCabecera> venCabeceras) {
		this.venCabeceras = venCabeceras;
	}

	public VenCabecera addVenCabecera(VenCabecera venCabecera) {
		getVenCabeceras().add(venCabecera);
		venCabecera.setCliCliente(this);

		return venCabecera;
	}

	public VenCabecera removeVenCabecera(VenCabecera venCabecera) {
		getVenCabeceras().remove(venCabecera);
		venCabecera.setCliCliente(null);

		return venCabecera;
	}

}