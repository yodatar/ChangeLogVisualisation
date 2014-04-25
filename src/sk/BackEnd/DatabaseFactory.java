package sk.BackEnd;

import com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:13
 */


public class DatabaseFactory {
	private static DatabaseFactory instance = null;
	private IAstRcsWcfSvc iAstRcsWcfSvc;
	private IActivitySvc iActivitySvc;

	private DatabaseFactory() {
		BackEndClient backEndClient = new BackEndClient();
		iAstRcsWcfSvc = backEndClient.connection();
		iActivitySvc = backEndClient.connection2();
	}

	public static DatabaseFactory getInstance() {
		if (instance == null) {
			instance = new DatabaseFactory();
		}
		return instance;
	}

	public IAstRcsWcfSvc getIAstRcsWcfSvc() {
		return iAstRcsWcfSvc;
	}

	public IActivitySvc getIActivitySvc() {
		return iActivitySvc;
	}

}
