package mpiatek.app.service;

import mpiatek.app.domain.Router;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ShopService {
    static public void addToCart(Router router, HttpServletRequest request, ServletContext context) {
        ArrayList<Router> list = (ArrayList<Router>) request.getSession().getAttribute("cart");
        list.add(router);
        request.getSession().setAttribute("cart",list);
        RouterService routerService = (RouterService) context.getAttribute("router_service");
        routerService.removeRouter(router.getId());
        context.setAttribute("router_service",routerService);
    }
    static public void addToCart(int id, HttpServletRequest request,ServletContext context) {

        ArrayList<Router> list = (ArrayList<Router>) request.getSession().getAttribute("cart");
        RouterService routerService = (RouterService) context.getAttribute("router_service");
        list.add(routerService.getRouter(id));
        request.getSession().setAttribute("cart",list);
        routerService.removeRouter(id);
        context.setAttribute("router_service",routerService);
    }
    static public void removeFromCart(int id, HttpServletRequest request, ServletContext context) {
        ArrayList<Router> list = (ArrayList<Router>) request.getSession().getAttribute("cart");
        for(Router router: list) {
            if(router.getId()==id) {
                list.remove(id);
                break;
            }
        }
        request.getSession().setAttribute("cart",list);
    }
    static public ArrayList<Router> getCart(HttpServletRequest request) {
        return (ArrayList<Router>) request.getSession().getAttribute("cart");
    }

}
