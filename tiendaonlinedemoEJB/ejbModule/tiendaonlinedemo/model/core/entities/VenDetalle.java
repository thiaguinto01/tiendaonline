package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ven_detalle database table.
 * 
 */
@Entity
@Table(name="ven_detalle")
@NamedQuery(name="VenDetalle.findAll", query="SELECT v FROM VenDetalle v")
public class VenDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ven_detalle", unique=true, nullable=false)
	private Integer idVenDetalle;

	@Column(name="ven_det_cantidad", nullable=false)
	private Integer venDetCantidad;

	@Column(name="ven_det_precio", nullable=false)
	private double venDetPrecio;

	//bi-directional many-to-one association to InvProducto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private InvProducto invProducto;

	//bi-directional many-to-one association to VenCabecera
	@ManyToOne
	@JoinColumn(name="id_ven_cabecera")
	private VenCabecera venCabecera;

	public VenDetalle() {
	}

	public Integer getIdVenDetalle() {
		return this.idVenDetalle;
	}

	public void setIdVenDetalle(Integer idVenDetalle) {
		this.idVenDetalle = idVenDetalle;
	}

	public Integer getVenDetCantidad() {
		return this.venDetCantidad;
	}

	public void setVenDetCantidad(Integer venDetCantidad) {
		this.venDetCantidad = venDetCantidad;
	}

	public double getVenDetPrecio() {
		return this.venDetPrecio;
	}

	public void setVenDetPrecio(double venDetPrecio) {
		this.venDetPrecio = venDetPrecio;
	}

	public InvProducto getInvProducto() {
		return this.invProducto;
	}

	public void setInvProducto(InvProducto invProducto) {
		this.invProducto = invProducto;
	}

	public VenCabecera getVenCabecera() {
		return this.venCabecera;
	}

	public void setVenCabecera(VenCabecera venCabecera) {
		this.venCabecera = venCabecera;
	}

}