package sk.BackEnd;

import com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

/**
 * Date: 7.12.2013
 */

/**
 * Trieda DatabaseFactory vyuziva navrhovy vzor Singleton,
 * a poskytuje instanciu rozhrania na koncove body IAstRcsWcfSvc a IActivitySvc.
 * @see BackEndClient
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

	/**
	 * Metoda poskytujuca instanciu rozhrania IAstRcsWcfSvc
	 * @return IAstRcsWcfSvc
	 */
	public IAstRcsWcfSvc getIAstRcsWcfSvc() {
		return iAstRcsWcfSvc;
	}

	/**
	 * Metoda poskytujuca instanciu rozhrania IActivitySvc
	 * @return IActivitySvc
	 */
	public IActivitySvc getIActivitySvc() {
		return iActivitySvc;
	}

}
