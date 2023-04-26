import com.lxf.dao.DependenciesDaoImpl;
import com.lxf.util.Node;

import java.util.ArrayList;

public class DependenciesDaoImplTest {
    public static void main(String[] args) throws Exception {
        DependenciesDaoImpl d = new DependenciesDaoImpl();
        Node node = new Node("APPS", "CUX_TABLE", "TABLE");
        ArrayList<Node> nodes = d.findAllNeighborNode(node);
        System.out.println(nodes);
    }
}
