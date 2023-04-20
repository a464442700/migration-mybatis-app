import com.lxf.util.Node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BFSTest {
    public static void main(String[] args) {
        Node node1 = new Node("1", "1", "1");
        Node node2 = new Node("1", "1", "1");
        Node node3 = new Node("1", "1", "2");
        node2.setLevel(node1);
        System.out.println(node1.hashCode());
        System.out.println(node2.hashCode());
        System.out.println(node3.hashCode());
        System.out.println(node1.equals(node2));

        HashSet<Node> set = new HashSet<Node>();
        set.add(node1);
        if (!set.contains(node1)) {
            System.out.println("不存在node1");
        }
        if (!set.contains(node2)) {
            System.out.println("不存在node2");
        }
        if (!set.contains(node3)) {
            System.out.println("不存在node3");
        }
        System.out.println(set);
    }
}
