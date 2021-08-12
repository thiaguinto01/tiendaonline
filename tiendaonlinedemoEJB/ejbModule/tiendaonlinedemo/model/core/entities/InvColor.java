package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_color database table.
 * 
 */
@Entity
@Table(name="inv_color")
@NamedQuery(name="InvColor.findAll", query="SELECT i FROM InvColor i")
public class InvColor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_color", unique=true, nullable=false)
	private Integer idColor;

	@Column(name="col_nombre", nullable=false, length=30)
	private String colNombre;

	//bi-directional many-to-one association to InvProducto
	@OneToMany(mappedBy="invColor")
	private List<InvProducto> invProductos;

	public InvColor() {
	}

	public Integer getIdColor() {
		return this.idColor;
	}

	public void setIdColor(Integer idColor) {
		this.idColor = idColor;
	}

	public String getColNombre() {
		return this.colNombre;
	}

	public void setColNombre(String colNombre) {
		this.colNombre = colNombre;
	}

	public List<InvProducto> getInvProductos() {
		return this.invProductos;
	}

	public void setInvProductos(List<InvProducto> invProductos) {
		this.invProductos = invProductos;
	}

	public InvProducto addInvProducto(InvProducto invProducto) {
		getInvProductos().add(invProducto);
		invProducto.setInvColor(this);

		return invProducto;
	}

	public InvProducto removeInvProducto(InvProducto invProducto) {
		getInvProductos().remove(invProducto);
		invProducto.setInvColor(null);

		return invProducto;
	}

}