package server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import server.entity.Sto;

@Stateless
@Local(TableDaoLocal.class)
public class TableDaoBean extends GenericDaoBean<Sto, Integer> implements TableDaoLocal {

}
