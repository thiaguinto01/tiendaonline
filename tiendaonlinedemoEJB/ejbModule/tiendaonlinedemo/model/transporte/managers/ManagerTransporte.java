package tiendaonlinedemo.model.transporte.managers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tiendaonlinedemo.model.core.entities.TransVehiculo;
import tiendaonlinedemo.model.transporte.dtos.DTOVehiculo;

/**
 * Session Bean implementation class ManagerTransporte
 */
@Stateless
@LocalBean
public class ManagerTransporte {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ManagerTransporte() {
        
    }
    public ArrayList<DTOVehiculo> findAllDTOVehiculo(){
    	ArrayList<DTOVehiculo> listado = new ArrayList<DTOVehiculo>();
    	listado.add(new DTOVehiculo(1, "ICB4589",2020, "1285 km","NEGRO"));
    	listado.add(new DTOVehiculo(2, "PDV1423",2021, "7895 km", "ROJO"));
    	listado.add(new DTOVehiculo(3, "ICB4589",2020, "9689 km", "BLANCO"));
    	return listado;
    }
    public List<TransVehiculo> findAllTransVehiculo (){
    	return em.createNamedQuery("TransVehiculo.findAll", TransVehiculo.class).getResultList();
    	
    }
}
