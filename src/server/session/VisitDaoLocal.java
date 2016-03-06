package server.session;

import java.util.List;

import server.entity.Poseta;

public interface VisitDaoLocal extends GenericDaoLocal<Poseta, Integer> {

	public List<Object[]> getPosete(int idGosta);
	
	public void rateVisit(int posetaId, int rate);
	
}
