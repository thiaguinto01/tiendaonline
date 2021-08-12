package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_tipo_producto database table.
 * 
 */
@Entity
@Table(name="inv_tipo_producto")
@NamedQuery(name="InvTipoProducto.findAll", query="SELECT i FROM InvTipoProducto i")
public class InvTipoProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tipo_producto", unique=true, nullable=false)
	private Integer idTipoProducto;

	@Column(name="tipo_descripcion", nullable=false, length=40)
	private String tipoDescripcion;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invTipoProducto")
	private List<InvProducto> invProductos;

	public InvTipoProducto() {
	}

	public Integer getIdTipoProducto() {
		return this.idTipoProducto;
	}

	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}

	public String getTipoDescripcion() {
		return this.tipoDescripcion;
	}

	public void setTipoDescripcion(String tipoDescripcion) {
		this.tipoDescripcion = tipoDescripcion;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvTipoProducto(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvTipoProducto(null);

		return invProducto;
	}

}