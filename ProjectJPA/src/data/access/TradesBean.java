package data.access;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(TradesBeanLocal.class)
@Remote(TradesBeanRemote.class)
public class TradesBean implements TradesBeanLocal, TradesBeanRemote {

	@PersistenceContext(unitName = "JPADB")
	private EntityManager entityManager;
	public TradesBean() {
		
	}
}
