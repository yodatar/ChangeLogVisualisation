package sk.AstRcs;

import com.gratex.perconik.astrcs.iastrcswcfsvc.IAstRcsWcfSvc;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 7.12.2013
 * Time: 20:13
 */


public class AstRcsDatabaseFactory {
    private IAstRcsWcfSvc iAstRcsWcfSvc;
    public AstRcsDatabaseFactory() {
        AstRcsClient astRcsClient = new AstRcsClient();
        iAstRcsWcfSvc = astRcsClient.connection();
    }

    public IAstRcsWcfSvc getIAstRcsWcfSvc() {
        return iAstRcsWcfSvc;
    }
}
