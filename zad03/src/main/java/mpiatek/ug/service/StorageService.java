package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.List;

import mpiatek.ug.domain.Router;

public class StorageService {

    private List<Router> db = new ArrayList<Router>();

    public void add(Router router){
        Router newRouter = new Router(router.getName(), router.getProdDate(),
                router.getWireless(),router.getFrequency());
        db.add(newRouter);
    }

    public List<Router> getAllRouters(){
        return db;
    }

}