package TestServlet.dao;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class Customers {
    Map<Integer, String> map = new HashMap<Integer, String>();

    public Customers() {
        map.put(0, "tom");
        map.put(1, "sergei");
        map.put(2, "alina");
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }
}
