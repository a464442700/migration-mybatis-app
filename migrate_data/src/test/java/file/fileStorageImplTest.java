package file;

import com.lxf.util.Node;
import com.lxf.util.file.FileStorageImpl;

public class fileStorageImplTest {
    public static void main(String[] args) {
        FileStorageImpl f=new FileStorageImpl();
        Node node = new Node("APPS", "CUX_TABLE", "TABLE");
        node.setDatabase("DUPDB");
        f.writeToFile(node);
    }
}
