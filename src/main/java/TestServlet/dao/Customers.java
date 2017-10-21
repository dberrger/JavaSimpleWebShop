package TestServlet.dao;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class Customers {
    Map<String, Integer> map = new HashMap<String, Integer>();

    public Customers() {
        map.put("tom", 2);
        map.put("sergi", 1);
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }
}
