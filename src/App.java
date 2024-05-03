import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static List<Node> mo = new LinkedList<>();
    private static List<Node> dong = new LinkedList<>();
    private static List<Distance> distances = new ArrayList<>();

    public static void main(String[] args) {
        init();
        while (mo.isEmpty()) {
            Node s = getMo();
            dong.add(s);
            if (s.isGoal) {
                System.out.println("Thanh cong");
                return;
            }
            List<Node> childS = child(s);
            if (!childS.isEmpty()) {
                Node root = new Node("A", 14, false);
                List<Integer> gs = new ArrayList<>();
                for (Node m : childS) {
                    // tính 1 hàm
                    // g(C) = g(A, root) + g(C, root) + h(C) 
                    // g(A, root) = khoảng cách từ A->root
                    // g(root, C) khoảng cách root->C)
                    // h(C) h tại C

                }
            }
        }    
    }

    private static Integer g(Node node) {
        
    }

    private static List<Node> child(Node s) {
        List<Node> res = new ArrayList<>();
        for (Distance d : distances) {
            if (d.node1.equals(s)) {
                res.add(d.node2);
            } else if (d.node2.equals(s)) {
                res.add(d.node1);
            }
        }
        return res;
    }

    private static Node getMo() {
        if (mo.isEmpty()) {
            return null;
        }
        Node res = mo.get(0);
        for (Node node : mo) {
            if (node.h < res.h) {
                res = node;
            }
        }
        return res;
    }

    private static void init() {
        Node a = new Node("A", 14, false);
        Node b = new Node("B", 10, false);
        Node c = new Node("C", 10, false);
        Node d = new Node("D", 10, false);
        Node e = new Node("E", 10, false);
        Node f = new Node("F", 10, false);
        Node g = new Node("G", 10, false);
        Node h = new Node("H*", 10, true);
        mo.addAll(List.of(a, b, c, d, e, f, g, h));

        distances.add(new Distance(a, b, 5));
        distances.add(new Distance(a, d, 7));
        distances.add(new Distance(a, c, 3));
        distances.add(new Distance(c, d, 2));
        distances.add(new Distance(c, e, 4));
        distances.add(new Distance(d, e, 6));
        distances.add(new Distance(e, g, 5));
        distances.add(new Distance(b, f, 7));
        distances.add(new Distance(b, h, 12));
        distances.add(new Distance(e, f, 3)); 
        distances.add(new Distance(f, g, 2));
        distances.add(new Distance(h, g, 3));
    }
}