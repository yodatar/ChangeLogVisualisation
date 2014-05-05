package sk.BackEnd;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * Created with IntelliJ IDEA.
 * User: pipo
 * Date: 4.3.2014
 * Time: 23:37
 */

// TODO: delete
public class MyObjectFactory {

	public JAXBElement<Integer> createFileVersionIdInteger(Integer value) {
		return new JAXBElement(new QName("http://schemas.datacontract.org/2004/07/Gratex.PerConIK.AstRcs.Svc.Interfaces", "FileVersionId"), Integer.class, value);
	}
}
