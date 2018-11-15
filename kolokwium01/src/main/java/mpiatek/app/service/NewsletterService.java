package mpiatek.app.service;

import mpiatek.app.domain.Newsletter;

import java.util.HashMap;
import java.util.Map;

public class NewsletterService {
    public int counter = 0;
    private Map<Integer, Newsletter> map = new HashMap<>();
    public void addNewsletter(Newsletter newsletter) {
        newsletter.setId(counter);
        map.put(counter, newsletter);
        counter++;
    }
    public Newsletter getNewsletter(int id) {return map.get(id); }

    public void removeNewsletter(int id) {
        map.remove(id);
    }

    public Map<Integer, Newsletter> getMap() {
        return map;
    }
}

