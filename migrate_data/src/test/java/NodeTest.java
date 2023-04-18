import com.lxf.util.Node;

public class NodeTest
{
    public static void main(String[] args) {
        Node node1 = new Node("1", "1", "1", 1);
        Node node2 = new Node("1", "1", "1", 2);
        node2.setLevel(node1);
        System.out.println(node2.getLevel());

    }
}
