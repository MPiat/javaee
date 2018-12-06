package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import mpiatek.ug.domain.Router;

@Singleton
public class RouterManager {

    private List<Router> db = Collections.synchronizedList(new ArrayList<>());

    public void addDefaultRouter() { db.add(new Router("Linksys",2000));}

    public void deleteRouter(Integer id){
        db.remove(id);
    }

    public void updateRouter(Integer id, Router router){
        Router change = db.get(id);
        change.setName(router.getName());
        change.setModelNum(router.getModelNum());
    }
    public void addRouter( Router router){
        db.add(new Router(router.getName(),router.getModelNum()));
    }

    public Router getRouter(Integer id) {
        return db.get(id);
    }

    public List<Router> getAllRouters(){
        return db;
    }

    public void deleteAllRouters(){
        db.clear();
    }

}