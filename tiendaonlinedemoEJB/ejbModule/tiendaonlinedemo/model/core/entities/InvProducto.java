package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_producto database table.
 * 
 */
@Entity
@Table(name="inv_producto")
@NamedQuery(name="InvProducto.findAll", query="SELECT i FROM InvProducto i")
public class InvProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto", unique=true, nullable=false)
	private Integer idProducto;

	@Column(name="pro_imagen")
	private byte[] proImagen;

	@Column(name="pro_precio", nullable=false)
	private double proPrecio;

	@Column(name="pro_stock", nullable=false)
	private Integer proStock;

	//bi-directional many-to-one association to InvColor
	@ManyToOne
	@JoinColumn(name="id_color")
	private InvColor invColor;

	//bi-directional many-to-one association to InvMarca
	@ManyToOne
	@JoinColumn(name="id_marca")
	private InvMarca invMarca;

	//bi-directional many-to-one association to InvTalla
	@ManyToOne
	@JoinColumn(name="id_talla")
	private InvTalla invTalla;

	//bi-directional many-to-one association to InvTipoProducto
	@ManyToOne
	@JoinColumn(name="id_tipo_producto")
	private InvTipoProducto invTipoProducto;

	//bi-directional many-to-one association to VenDetalle
	@OneToMany(mappedBy="invProducto")
	private List<VenDetalle> venDetalles;

	public InvProducto() {
	}

	public Integer getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public byte[] getProImagen() {
		return this.proImagen;
	}

	public void setProImagen(byte[] proImagen) {
		this.proImagen = proImagen;
	}

	public double getProPrecio() {
		return this.proPrecio;
	}

	public void setProPrecio(double proPrecio) {
		this.proPrecio = proPrecio;
	}

	public Integer getProStock() {
		return this.proStock;
	}

	public void setProStock(Integer proStock) {
		this.proStock = proStock;
	}

	public InvColor getInvColor() {
		return this.invColor;
	}

	public void setInvColor(InvColor invColor) {
		this.invColor = invColor;
	}

	public InvMarca getInvMarca() {
		return this.invMarca;
	}

	public void setInvMarca(InvMarca invMarca) {
		this.invMarca = invMarca;
	}

	public InvTalla getInvTalla() {
		return this.invTalla;
	}

	public void setInvTalla(InvTalla invTalla) {
		this.invTalla = invTalla;
	}

	public InvTipoProducto getInvTipoProducto() {
		return this.invTipoProducto;
	}

	public void setInvTipoProducto(InvTipoProducto invTipoProducto) {
		this.invTipoProducto = invTipoProducto;
	}

	public List<VenDetalle> getVenDetalles() {
		return this.venDetalles;
	}

	public void setVenDetalles(List<VenDetalle> venDetalles) {
		this.venDetalles = venDetalles;
	}

	public VenDetalle addVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().add(venDetalle);
		venDetalle.setInvProducto(this);

		return venDetalle;
	}

	public VenDetalle removeVenDetalle(VenDetalle venDetalle) {
		getVenDetalles().remove(venDetalle);
		venDetalle.setInvProducto(null);

		return venDetalle;
	}

}