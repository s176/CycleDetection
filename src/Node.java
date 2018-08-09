class Node {

    private int index;
    private Node nextNode;

    Node(int index) {
        this.index = index;
    }

    int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }

    Node getNextNode() {
        return nextNode;
    }

    void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
