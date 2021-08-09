package tiendaonlinedemo.api.soap.thumano;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import tiendaonlinedemo.model.thumano.dtos.DTOThmCargo;
import tiendaonlinedemo.model.thumano.managers.ManagerTHumano;

@WebService(serviceName = "ServiceSOAPTHumano")
public class ServiceSOAPTHumano {
	@EJB
	private ManagerTHumano mTHumano;
	
	@WebMethod(operationName = "findAllDTOThmCargo")
	public List<DTOThmCargo> findAllDTOThmCargo(){
		return mTHumano.findAllDTOThmCargo();
	}
}
