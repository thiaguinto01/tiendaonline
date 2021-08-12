package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cli_contacto database table.
 * 
 */
@Entity
@Table(name="cli_contacto")
@NamedQuery(name="CliContacto.findAll", query="SELECT c FROM CliContacto c")
public class CliContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_num_telefono", unique=true, nullable=false)
	private Integer idNumTelefono;

	@Column(name="num_celular", length=10)
	private String numCelular;

	@Column(name="num_convencional", length=9)
	private String numConvencional;

	//bi-directional many-to-one association to CliCliente
	@OneToMany(mappedBy="cliContacto")
	private List<CliCliente> cliClientes;

	public CliContacto() {
	}

	public Integer getIdNumTelefono() {
		return this.idNumTelefono;
	}

	public void setIdNumTelefono(Integer idNumTelefono) {
		this.idNumTelefono = idNumTelefono;
	}

	public String getNumCelular() {
		return this.numCelular;
	}

	public void setNumCelular(String numCelular) {
		this.numCelular = numCelular;
	}

	public String getNumConvencional() {
		return this.numConvencional;
	}

	public void setNumConvencional(String numConvencional) {
		this.numConvencional = numConvencional;
	}

	public List<CliCliente> getCliClientes() {
		return this.cliClientes;
	}

	public void setCliClientes(List<CliCliente> cliClientes) {
		this.cliClientes = cliClientes;
	}

	public CliCliente addCliCliente(CliCliente cliCliente) {
		getCliClientes().add(cliCliente);
		cliCliente.setCliContacto(this);

		return cliCliente;
	}

	public CliCliente removeCliCliente(CliCliente cliCliente) {
		getCliClientes().remove(cliCliente);
		cliCliente.setCliContacto(null);

		return cliCliente;
	}

}