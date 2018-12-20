package mpiatek.app.config;


import mpiatek.app.domain.Router;
import mpiatek.app.service.RouterService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.GregorianCalendar;

@WebListener
public class Config implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        // Do stuff during webapp's startup.
        RouterService routerService = new RouterService();
        routerService.addRouter(new Router("TP-Link Archer",new GregorianCalendar(2015, 0, 1).getTime(),0.3,true));
        routerService.addRouter(new Router("Linksys 3000",new GregorianCalendar(2011, 1, 20).getTime(),1.2,false));
        event.getServletContext().setAttribute("routerService",routerService);
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

}