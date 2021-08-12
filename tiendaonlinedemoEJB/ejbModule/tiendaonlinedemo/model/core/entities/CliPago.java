package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cli_pago database table.
 * 
 */
@Entity
@Table(name="cli_pago")
@NamedQuery(name="CliPago.findAll", query="SELECT c FROM CliPago c")
public class CliPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pago", unique=true, nullable=false)
	private Integer idPago;

	@Column(name="pag_tipo", nullable=false, length=20)
	private String pagTipo;

	//bi-directional many-to-one association to CliCliente
	@OneToMany(mappedBy="cliPago")
	private List<CliCliente> cliClientes;

	public CliPago() {
	}

	public Integer getIdPago() {
		return this.idPago;
	}

	public void setIdPago(Integer idPago) {
		this.idPago = idPago;
	}

	public String getPagTipo() {
		return this.pagTipo;
	}

	public void setPagTipo(String pagTipo) {
		this.pagTipo = pagTipo;
	}

	public List<CliCliente> getCliClientes() {
		return this.cliClientes;
	}

	public void setCliClientes(List<CliCliente> cliClientes) {
		this.cliClientes = cliClientes;
	}

	public CliCliente addCliCliente(CliCliente cliCliente) {
		getCliClientes().add(cliCliente);
		cliCliente.setCliPago(this);

		return cliCliente;
	}

	public CliCliente removeCliCliente(CliCliente cliCliente) {
		getCliClientes().remove(cliCliente);
		cliCliente.setCliPago(null);

		return cliCliente;
	}

}