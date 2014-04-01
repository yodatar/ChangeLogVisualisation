package sk.BackEnd;

import com.gratex.perconik.astrcs.iactivitysvc.ActivitySvc;
import com.gratex.perconik.astrcs.iactivitysvc.IActivitySvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.AstRcsWcfSvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

import javax.xml.ws.WebServiceException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 12.11.2013
 * Time: 0:37
 */

public class BackEndClient {

	private final static String USERNAME = "Steltecia\\PublicServices";
	private final static String PASSWORD = "FiitSvc123.";

	public static class MyNtlmAuth extends Authenticator {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
		}
	}

	public IAstRcsWcfSvc connection() {
		IAstRcsWcfSvc basicBinding = null;
		Authenticator.setDefault(new MyNtlmAuth());
		AstRcsWcfSvc astRcsWcfSvc;
		try {
			astRcsWcfSvc = new AstRcsWcfSvc();
			basicBinding = astRcsWcfSvc.getBasicHttpBindingIAstRcsWcfSvc();
		} catch (WebServiceException e) {

		}

		return basicBinding;
	}

	public IActivitySvc connection2() {
		Authenticator.setDefault(new MyNtlmAuth());
		ActivitySvc activitySvc = new ActivitySvc();
		IActivitySvc basicBinding = activitySvc.getBasicHttpBindingIActivitySvc();

		return basicBinding;
	}
}