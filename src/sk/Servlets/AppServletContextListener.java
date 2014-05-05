package sk.Servlets;

import sk.BusinessLogic.Resources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application scope predefined values.
 *
 * Date: 10.3.2014
 * @author Pavol Michalek
 */
public class AppServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Resources resources = Resources.getInstance();
		resources.setProjectId(3);
		resources.setChangesetFromId(1386);
		resources.setChangesetToId(1490);

		//projectSelect=5 changesetFrom=1042 changesetTo=1058
	}

}