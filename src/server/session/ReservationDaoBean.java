package server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import server.entity.Rezervacija;

@Stateless
@Local(ReservationDaoLocal.class)
public class ReservationDaoBean extends GenericDaoBean<Rezervacija, Integer> implements ReservationDaoLocal {

}
