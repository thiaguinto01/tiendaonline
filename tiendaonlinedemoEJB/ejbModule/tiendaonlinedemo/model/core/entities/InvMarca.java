package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_marca database table.
 * 
 */
@Entity
@Table(name="inv_marca")
@NamedQuery(name="InvMarca.findAll", query="SELECT i FROM InvMarca i")
public class InvMarca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_marca", unique=true, nullable=false)
	private Integer idMarca;

	@Column(name="mar_nombre", nullable=false, length=20)
	private String marNombre;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invMarca")
	private List<InvProducto> invProductos;

	public InvMarca() {
	}

	public Integer getIdMarca() {
		return this.idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getMarNombre() {
		return this.marNombre;
	}

	public void setMarNombre(String marNombre) {
		this.marNombre = marNombre;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvMarca(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvMarca(null);

		return invProducto;
	}

}