import java.util.LinkedList;
import java.util.Queue;

public class LinkTest
{
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("a");
        if (queue.isEmpty()) {
            System.out.println("队列为空");
        } else {
            System.out.println("队列不为空");
        }
        queue.poll();
        if (queue.isEmpty()) {
            System.out.println("队列为空");
        } else {
            System.out.println("队列不为空");
        }
    }
}
