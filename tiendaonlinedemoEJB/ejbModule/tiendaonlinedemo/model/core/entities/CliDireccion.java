package tiendaonlinedemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cli_direccion database table.
 * 
 */
@Entity
@Table(name="cli_direccion")
@NamedQuery(name="CliDireccion.findAll", query="SELECT c FROM CliDireccion c")
public class CliDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_direccion", unique=true, nullable=false)
	private Integer idDireccion;

	@Column(name="direc_calle_principal", nullable=false, length=60)
	private String direcCallePrincipal;

	@Column(name="direc_calle_secundaria", nullable=false, length=60)
	private String direcCalleSecundaria;

	@Column(name="direc_numero", nullable=false)
	private Integer direcNumero;

	//bi-directional many-to-one association to CliCliente
	@OneToMany(mappedBy="cliDireccion")
	private List<CliCliente> cliClientes;

	public CliDireccion() {
	}

	public Integer getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getDirecCallePrincipal() {
		return this.direcCallePrincipal;
	}

	public void setDirecCallePrincipal(String direcCallePrincipal) {
		this.direcCallePrincipal = direcCallePrincipal;
	}

	public String getDirecCalleSecundaria() {
		return this.direcCalleSecundaria;
	}

	public void setDirecCalleSecundaria(String direcCalleSecundaria) {
		this.direcCalleSecundaria = direcCalleSecundaria;
	}

	public Integer getDirecNumero() {
		return this.direcNumero;
	}

	public void setDirecNumero(Integer direcNumero) {
		this.direcNumero = direcNumero;
	}

	public List<CliCliente> getCliClientes() {
		return this.cliClientes;
	}

	public void setCliClientes(List<CliCliente> cliClientes) {
		this.cliClientes = cliClientes;
	}

	public CliCliente addCliCliente(CliCliente cliCliente) {
		getCliClientes().add(cliCliente);
		cliCliente.setCliDireccion(this);

		return cliCliente;
	}

	public CliCliente removeCliCliente(CliCliente cliCliente) {
		getCliClientes().remove(cliCliente);
		cliCliente.setCliDireccion(null);

		return cliCliente;
	}

}