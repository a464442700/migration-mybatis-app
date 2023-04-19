import com.lxf.util.Node;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }
    }
}
