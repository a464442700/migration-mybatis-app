import com.lxf.util.BFS;
import com.lxf.util.Node;
import com.lxf.util.file.FileStorageImpl;

public class BFSTravelTest {
    public static void main(String[] args) {
        Node node =new Node("APPS","CUX_TABLE_PUB","PACKAGE");
        BFS bfs=new BFS(node);
        bfs.Traverse();
        System.out.println(bfs.getStack());
        System.out.println(bfs.getSet());
        System.out.println(bfs.getGraph());
//        for (Node n : bfs.getStack()) {
//            System.out.println(n);
//        }
        FileStorageImpl f=new FileStorageImpl();
        f.dealNodes(bfs.getStack());
        for (Node n : bfs.getStack()) {
            f.writeToFile(n);
        }

    }
}
//React-Force-Graph