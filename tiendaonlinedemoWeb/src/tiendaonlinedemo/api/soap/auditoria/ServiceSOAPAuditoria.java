package tiendaonlinedemo.api.soap.auditoria;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;

import tiendaonlinedemo.model.auditoria.managers.ManagerAuditoria;
import tiendaonlinedemo.model.core.entities.AudBitacora;
import tiendaonlinedemo.model.core.utils.ModelUtil;

@WebService(serviceName = "ServiceSOAPAuditoria")
public class ServiceSOAPAuditoria {
	@EJB
	private ManagerAuditoria mAuditoria;
	
	@WebMethod(operationName = "findBitacoraAyer")
	public List<AudBitacora> findBitacoraAyer(){
		return mAuditoria.findBitacoraByFecha(ModelUtil.addDays(new Date(), -1), new Date());
	}
	
	@WebMethod(operationName = "eliminarBitacora")
	public void eliminarBitacora() {
		mAuditoria.eliminarBitacora();
	}
	
}
