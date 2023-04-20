public class EqualsTest {

    public static void main(String[] args) {
        String a="1234556789123456789";
        NodeName node1 =new NodeName("1234556789123456789");
        System.out.println(a==node1.name);
        System.out.println("1234556789123456789"==node1.name);

        NodeName node2 =new NodeName("1234556789123456789");
        System.out.println(a==node2.name);
        System.out.println("1234556789123456789"==node2.name);
        System.out.println(node1.name==node2.name);
    }
}
