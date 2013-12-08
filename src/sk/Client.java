package sk;

import com.gratex.perconik.astrcs.iastrcswcfsvc.AstRcsWcfSvc;
import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 12.11.2013
 * Time: 0:37
 */

public class Client {

    private final static String USERNAME = "Steltecia\\PublicServices";
    private final static String PASSWORD = "FiitSvc123.";

    public static class MyNtlmAuth extends Authenticator {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
        }
    }

    public IAstRcsWcfSvc connection()
    {
        Authenticator.setDefault(new MyNtlmAuth());
        AstRcsWcfSvc astRcsWcfSvc = new AstRcsWcfSvc();
        IAstRcsWcfSvc basicBinding = astRcsWcfSvc.getBasicHttpBindingIAstRcsWcfSvc();
        return basicBinding;
    }
}