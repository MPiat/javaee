package mpiatek.app.service;

import mpiatek.app.domain.Router;

import java.util.HashMap;
import java.util.Map;

public class RouterService {
    public int counter = 0;
    private Map<Integer, Router> map = new HashMap<>();
    public void addRouter(Router router) {
        router.setId(counter);
        map.put(counter, router);
        counter++;
    }
    public Router getRouter(int id) {return map.get(id); }
    public Router getRouter(String name) {
        int i = 0;
        while(i<map.size()) {
            i++;
            if(map.get(i).getName().equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }
    public void removeRouter(int id) {
        map.remove(id);
    }

    public Map<Integer, Router> getMap() {
        return map;
    }
}
