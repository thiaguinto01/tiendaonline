package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_talla database table.
 * 
 */
@Entity
@Table(name="inv_talla")
@NamedQuery(name="InvTalla.findAll", query="SELECT i FROM InvTalla i")
public class InvTalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_talla", unique=true, nullable=false)
	private Integer idTalla;

	@Column(name="tall_descripcion", nullable=false, length=20)
	private String tallDescripcion;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invTalla")
	private List<InvProducto> invProductos;

	public InvTalla() {
	}

	public Integer getIdTalla() {
		return this.idTalla;
	}

	public void setIdTalla(Integer idTalla) {
		this.idTalla = idTalla;
	}

	public String getTallDescripcion() {
		return this.tallDescripcion;
	}

	public void setTallDescripcion(String tallDescripcion) {
		this.tallDescripcion = tallDescripcion;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvTalla(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvTalla(null);

		return invProducto;
	}

}