package mpiatek.ug.service;

import java.util.ArrayList;
import java.util.List;

import mpiatek.ug.domain.Router;

public class StorageService {

    private List<Router> db = new ArrayList<Router>();
    private List<Router> cart = new ArrayList<Router>();

    public void add(Router router){
        Router newRouter = new Router(router.getName(), router.getProd(),
                router.getWireless(),router.getFrequency());
        db.add(newRouter);
    }
    public void addCart(Router router){
        Router newRouter = new Router(router.getName(), router.getProd(),
                router.getWireless(),router.getFrequency());
        cart.add(newRouter);
    }
    public List<Router> getAllRouters(){
        return db;
    }
    public List<Router> getCart(){
        return cart;
    }

}