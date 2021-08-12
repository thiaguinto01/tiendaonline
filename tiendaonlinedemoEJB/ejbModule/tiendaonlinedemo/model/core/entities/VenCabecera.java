package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ven_cabecera database table.
 * 
 */
@Entity
@Table(name="ven_cabecera")
@NamedQuery(name="VenCabecera.findAll", query="SELECT v FROM VenCabecera v")
public class VenCabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ven_cabecera", unique=true, nullable=false)
	private Integer idVenCabecera;

	@Column(name="id_thm_empleado")
	private Integer idThmEmpleado;

	@Temporal(TemporalType.DATE)
	@Column(name="ven_cab_fecha", nullable=false)
	private Date venCabFecha;

	@Column(name="ven_cab_iva", nullable=false, precision=7, scale=2)
	private BigDecimal venCabIva;

	@Column(name="ven_cab_total", nullable=false, precision=7, scale=2)
	private BigDecimal venCabTotal;

	//bi-directional many-to-one association to CliCliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private CliCliente cliCliente;

	//bi-directional many-to-one association to VenDetalle
	@OneToMany(mappedBy="venCabecera")
	private List<VenDetalle> venDetalles;

	public VenCabecera() {
	}

	public Integer getIdVenCabecera() {
		return this.idVenCabecera;
	}

	public void setIdVenCabecera(Integer idVenCabecera) {
		this.idVenCabecera = idVenCabecera;
	}

	public Integer getIdThmEmpleado() {
		return this.idThmEmpleado;
	}

	public void setIdThmEmpleado(Integer idThmEmpleado) {
		this.idThmEmpleado = idThmEmpleado;
	}

	public Date getVenCabFecha() {
		return this.venCabFecha;
	}

	public void setVenCabFecha(Date venCabFecha) {
		this.venCabFecha = venCabFecha;
	}

	public BigDecimal getVenCabIva() {
		return this.venCabIva;
	}

	public void setVenCabIva(BigDecimal venCabIva) {
		this.venCabIva = venCabIva;
	}

	public BigDecimal getVenCabTotal() {
		return this.venCabTotal;
	}

	public void setVenCabTotal(BigDecimal venCabTotal) {
		this.venCabTotal = venCabTotal;
	}

	public CliCliente getCliCliente() {
		return this.cliCliente;
	}

	public void setCliCliente(CliCliente cliCliente) {
		this.cliCliente = cliCliente;
	}

	public List<VenDetalle> getVenDetalles() {
		return this.venDetalles;
	}

	public void setVenDetalles(List<VenDetalle> venDetalles) {
		this.venDetalles = venDetalles;
	}

	public VenDetalle addVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().add(venDetalle);
		venDetalle.setVenCabecera(this);

		return venDetalle;
	}

	public VenDetalle removeVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().remove(venDetalle);
		venDetalle.setVenCabecera(null);

		return venDetalle;
	}

}