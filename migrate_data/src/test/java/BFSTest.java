import com.lxf.util.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BFSTest {
    public static void main(String[] args) {
        Node node1 = new Node("1", "1", "1", 1);
        Node node2 = new Node("1", "1", "1", 1);

        Set<Node> set = new HashSet<Node>();
        set.add(node1);
        if (set.contains(node1)) {
            System.out.println("存在node1");
        }
        if (set.contains(node2)) {
            System.out.println("存在node2");
        }
    }
}
