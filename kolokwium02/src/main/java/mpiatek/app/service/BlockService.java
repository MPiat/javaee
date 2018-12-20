package mpiatek.app.service;

import mpiatek.app.domain.Block;

import java.util.HashMap;
import java.util.Map;

public class BlockService {
    public int counter = 0;
    private Map<Integer, Block> map = new HashMap<>();
    public void addBlock(Block block) {
        block.setId(counter);
        map.put(counter, block);
        counter++;
    }
    public Block getBlock(int id) {return map.get(id); }
    public Block getBlock(String name) {
        int i = 0;
        while(i<map.size()) {
            i++;
            if(map.get(i).getName().equals(name)) {
                return map.get(i);
            }
        }
        return null;
    }
    public void removeBlock(int id) {
        map.remove(id);
    }

    public Map<Integer, Block> getMap() {
        return map;
    }
}
