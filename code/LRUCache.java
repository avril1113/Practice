class LRUCache {
    int size;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap();
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, head, null);
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        Node node = map.get(key);
        
        if (head.next != node) {
            Node first = head.next;
            node.pre.next = node.next;
            node.next.pre = node.pre;
            head.next.pre = node;
            node.next = head.next;
            head.next = node;
            node.pre = head;
        }
        return node.val;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            Node node = map.get(key);
            node.val = value;
        } else {
            Node node = new Node(key, value, head, head.next);
            head.next.pre = node;
            head.next = node;
            map.put(key, node);
            
            if (map.size() > size) {
                map.remove(tail.pre.key);
                tail.pre = tail.pre.pre;
                tail.pre.next = tail;
            }            
        }
    }
    
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        
        public Node(int key, int val, Node pre, Node next) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */