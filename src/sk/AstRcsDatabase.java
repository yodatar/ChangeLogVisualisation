package sk;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:13
 */


public class AstRcsDatabase {
    private IAstRcsWcfSvc iAstRcsWcfSvc;
    public AstRcsDatabase() {
        Client client = new Client();
        iAstRcsWcfSvc = client.connection();
    }

    public IAstRcsWcfSvc getIAstRcsWcfSvc() {
        return iAstRcsWcfSvc;
    }
}
