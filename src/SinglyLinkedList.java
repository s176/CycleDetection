import java.util.HashSet;

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    Node getHead() {
        return head;
    }

    void setHead(Node head) {
        this.head = head;
    }

    Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    SinglyLinkedList() {
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    void addFront(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNextNode(head);
            head = node;
        }
    }

    void addBack(Node node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
            tail.setNextNode(null); // make sure added node is really the last one
        }
    }

    void deleteNode(Node node) {
        if (head == null || tail == null)
            return;

        if (head == node && tail == node) {
            head = null;
            tail = null;
            return;
        }

        if (head == node && head.getNextNode() != null) {
            head = head.getNextNode();
            return;
        }

        Node t = head;
        HashSet<Node> s = new HashSet<>();
        while (t.getNextNode() != null) {
            if (t.getNextNode() == node) {
                if (tail == t.getNextNode()) {
                    tail = t;
                }
                t.setNextNode(t.getNextNode().getNextNode());
                return;
            }
            if (s.contains(t))
                break;
            s.add(t);
            t = t.getNextNode();
        }
    }

    void printList() {
        HashSet<Node> s = new HashSet<>();
        Node node = head;
        String prefix = "";
        while (node != null) {
            System.out.print(prefix + node.getIndex());
            prefix = " -> ";
            if (s.contains(node)) {
                break;
            }
            s.add(node);
            node = node.getNextNode();
        }
    }

    void detectCycleByHash() {
        System.out.print("\nDetect cycle using hashing ... ");
        HashSet<Node> s = new HashSet<>();
        Node node = head;
        boolean hasCycle = false;
        boolean isCycledToHead = false;
        int iterationsCount = 0;
        while (node != null) {
            iterationsCount++;
            if (s.contains(node)) {
                hasCycle = true;
                if (node == head) {
                    isCycledToHead = true;
                }
                break;
            }
            s.add(node);
            node = node.getNextNode();
        }
        System.out.println("Count of iterations: " + iterationsCount);
        if (hasCycle) {
            System.out.println("There is a cycle in list.");
            if (isCycledToHead) {
                System.out.println("And cycle goes from tail to head.");
            } else {
                System.out.println("And cycle goes from tail to not a head.");
            }
            //add detection of cycle from tail to tail
        } else {
            System.out.println("There is no cycle in list.");
        }
    }

    void detectCycleByFloyd() {
        System.out.print("\nDetect cycle using Floyd’s Cycle-Finding Algorithm ... ");
        Node slowPointer = head;
        Node fastPointer = head;
        boolean hasCycle = false;
        int iterationsCount = 0;
        while (slowPointer != null && fastPointer != null && fastPointer.getNextNode() != null) {
            iterationsCount++;
            slowPointer = slowPointer.getNextNode();
            fastPointer = fastPointer.getNextNode().getNextNode();
            if (slowPointer == fastPointer) {
                hasCycle = true;
                break;
            }
        }
        System.out.println("Count of iterations: " + iterationsCount);
        if (hasCycle) {
            System.out.println("There is a cycle in list.");
        } else {
            System.out.println("There is no cylce in list.");
        }
    }
}
