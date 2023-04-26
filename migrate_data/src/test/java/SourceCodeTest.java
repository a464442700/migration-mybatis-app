import com.lxf.dao.SourceCodeDaoImpl;
import com.lxf.util.Node;

public class SourceCodeTest {
    public static void main(String[] args) {
        Node node1 = new Node("APPS", "CUX_TABLE_PUB", "PACKAGE");
        SourceCodeDaoImpl s=new SourceCodeDaoImpl();
        s.getSourcode(node1);
        System.out.println(node1.getSourceCode());
        s.getSourcodeHash(node1);
    }
}
