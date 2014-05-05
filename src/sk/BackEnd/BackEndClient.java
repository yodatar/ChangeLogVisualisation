package sk.BackEnd;

import com.gratex.perconik.astrcs.iactivitysvc.ActivitySvc;
import com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.AstRcsWcfSvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

import javax.xml.ws.WebServiceException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.PasswordAuthentication;

/**
 * Trieda BackEndClient vytvara spojenie s webovymi sluzbami AstRcsWcfSvc a UserActivity.
 *
 * @author Pavol Michalek
 * @see MyNtlmAuth
 */
public class BackEndClient {

	private final static String USERNAME = "Steltecia\\PublicServices";
	private final static String PASSWORD = "FiitSvc123.";

	/**
	 * Staticka trieda MyNtlmAuth rozsiruje triedu Authenticator.
	 * Nastavuje sa ako prednastvaeny autentikacny nastroj.
	 *
	 * @see Authenticator
	 */
	public static class MyNtlmAuth extends Authenticator {
		/**
		 * Prekonana metoda triedy Authenticator.
		 * Poskytuje autentikacne udaje pre protokol NTLM.
		 *
		 * @return PasswordAuthentication
		 */
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
		}
	}

	/**
	 * Metoda na ziskanie getBasicHttpBindingIAstRcsWcfSvc().
	 *
	 * @return IAstRcsWcfSvc
	 * @throws WebServiceException
	 */
	public IAstRcsWcfSvc connection() {
		IAstRcsWcfSvc basicBinding = null;
		Authenticator.setDefault(new MyNtlmAuth());
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		try {
			AstRcsWcfSvc astRcsWcfSvc = new AstRcsWcfSvc();
			basicBinding = astRcsWcfSvc.getBasicHttpBindingIAstRcsWcfSvc();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}

		return basicBinding;
	}

	/**
	 * Metoda na ziskanie getBasicHttpBindingIActivitySvc().
	 *
	 * @return IActivitySvc
	 * @throws WebServiceException
	 */
	public IActivitySvc connection2() {
		IActivitySvc basicBinding = null;
		Authenticator.setDefault(new MyNtlmAuth());
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		try {
			ActivitySvc activitySvc = new ActivitySvc();
			basicBinding = activitySvc.getBasicHttpBindingIActivitySvc();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}

		return basicBinding;
	}
}