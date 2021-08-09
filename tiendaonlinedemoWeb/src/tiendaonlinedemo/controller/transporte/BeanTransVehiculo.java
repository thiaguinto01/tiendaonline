package tiendaonlinedemo.controller.transporte;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import tiendaonlinedemo.model.core.entities.TransVehiculo;
import tiendaonlinedemo.model.transporte.dtos.DTOVehiculo;
import tiendaonlinedemo.model.transporte.managers.ManagerTransporte;

@Named
@SessionScoped
public class BeanTransVehiculo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@EJB
	private ManagerTransporte managerTransporte;
	private List<TransVehiculo> listaVehiculos;
	
	
	public BeanTransVehiculo() {
		
	}
	@PostConstruct
	public void inicializar () {
		listaVehiculos= managerTransporte.findAllTransVehiculo();
	}
	public List<TransVehiculo> getListaVehiculos() {
		return listaVehiculos;
	}
	public void setListaVehiculos(List<TransVehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}
	
}
