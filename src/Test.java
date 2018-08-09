import java.util.ArrayList;

class Test {

    static void listOperations() {

        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("\n---------------- Testing list operations --------------");
        System.out.println("\nAdd 5 nodes to back of list:");
        for (int i = 1; i < 6; i++) {
            singlyLinkedList.addBack(new Node(i));
        }
        singlyLinkedList.printList();

        System.out.println("\nAdd 5 nodes to front of list:");
        for (int i = 0; i > -5; i--) {
            singlyLinkedList.addFront(new Node(i));
        }
        singlyLinkedList.printList();

        System.out.println("\nDelete first, second and last nodes of list:");
        singlyLinkedList.deleteNode(singlyLinkedList.getHead());
        singlyLinkedList.deleteNode(singlyLinkedList.getHead().getNextNode());
        singlyLinkedList.deleteNode(singlyLinkedList.getTail());
        singlyLinkedList.printList();

        System.out.println("\nCycle this list:");
        singlyLinkedList.getTail().setNextNode(singlyLinkedList.getHead());
        singlyLinkedList.printList();

        System.out.println("\nTry to delete node, which is not present in cycled linked list:");
        singlyLinkedList.deleteNode(new Node(100));
        singlyLinkedList.printList();
        System.out.println("");
    }

    static void detectCycleTypeOfList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("\n---------------- Detecting list cycle type --------------");
        System.out.println("\n1. Create plane list without cycle:");
        for (int i = 0; i < 10; i++) {
            singlyLinkedList.addBack(new Node(i));
        }
        singlyLinkedList.printList();
        singlyLinkedList.detectCycleByHash();
        singlyLinkedList.detectCycleByFloyd();

        System.out.println("\n2. Cycle list from tale to head:");
        singlyLinkedList.getTail().setNextNode(singlyLinkedList.getHead());
        singlyLinkedList.printList();
        singlyLinkedList.detectCycleByHash();
        singlyLinkedList.detectCycleByFloyd();

        System.out.println("\n3. Cycle list from tale to not a head:");
        singlyLinkedList.getTail().setNextNode(singlyLinkedList.getHead().getNextNode().getNextNode().getNextNode());
        singlyLinkedList.printList();
        singlyLinkedList.detectCycleByHash();
        singlyLinkedList.detectCycleByFloyd();
    }

    static void detectCycleInRandomList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("\n---------------- Detecting cycle in random list --------------");
        System.out.println("\nCreate random list:");
        int nodesCount = 1000000;
        int headIndex = (int) (Math.random() * nodesCount);
        // Initialize source of Nodes
        ArrayList<Node> sourceOfNodes = new ArrayList<>();
        for (int i = 0; i < nodesCount; i++) {
            sourceOfNodes.add(new Node(i));
        }
        // Create random linkes between nodes
        for (Node element : sourceOfNodes) {
            int randomIndex = (int) (Math.random() * nodesCount);
            element.setNextNode(sourceOfNodes.get(randomIndex));
        }
        //Bind random node as head of linked list
        singlyLinkedList.setHead(sourceOfNodes.get(headIndex));
        singlyLinkedList.printList();
        singlyLinkedList.detectCycleByHash();
        singlyLinkedList.detectCycleByFloyd();
    }
}
