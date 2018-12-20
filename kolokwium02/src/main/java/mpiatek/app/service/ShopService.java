package mpiatek.app.service;

import mpiatek.app.domain.Block;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private List<Block> cart = new ArrayList<>();
    public void addToCart(Block block) {
        cart.add(block);
    }
    public void removeFromCart(Block block) {
        cart.remove(block);
    }
    public List<Block> getCart() {
        return cart;
    }

}
