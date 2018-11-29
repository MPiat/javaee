package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import mpiatek.ug.domain.Router;

@Singleton
public class RouterManager {

    private List<Router> db = Collections.synchronizedList(new ArrayList<>());

    public void addRouter(Router router) {
        db.add(router);
    }
    public void addDefaultRouter() { db.add(new Router("Linksys",2000));}

    public void deleteRouter(Router router){
        db.remove(router);
    }

//    //public void updateRouter(Router router){
//        db.remove(router);
//    }

    public Router getRouter(Integer id) {
        return new Router("TP-Link", 3000);
    }

    public List<Router> getAllRouters(){
        return db;
    }

    public void deleteAllRouters(){
        db.clear();
    }

}