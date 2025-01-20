package org.example;

class ChainingHashTable {
    public ChainingHashTable(int capacity) {
        currentSize=0;
        this.maxSize = capacity;
        nodes = new Node[maxSize];

    }

    class Node{
        String value;
        Node nextNode;

        public Node(String value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;

        }
    }

    Node[] nodes;
    int maxSize;
    int currentSize;

    // Method 1
    // Function to clear hash table
    public void makeEmpty() {currentSize=0;
    nodes = new Node[maxSize];
    }

    // Method 2
    // Function to get the size of the hash table
    public int getSize() {
    return currentSize;
    }

    // Method 3
    // Function to check if the hash table is full
    public boolean isFull() {
        for (Node node :nodes){
            if(node!=null){
                return false;
            }
        }
        return true;
    }

    // Method 4
    // Function to check if the hash table is empty
    public boolean isEmpty(){
    return getSize()==0;
    }

    // Method 5
    // Function to check if the hash table contains a value
    public boolean contains(String value) {
        for (Node node :nodes){
            if(node!=null){
                return true;
            }
        }
        return false;
    }

    // Method 6
    // Function to get the hash code of a given string



    private int hash(String value) {

        int hashcode=0;
        for(int i=0;i<value.length();i++){
            hashcode+=value.charAt(i);
        }
        hashcode=hashcode%maxSize;
        return hashcode;
//        int hashcode=0;
//        for(int i=0;i<value.length();i++){
//            hashcode+=value.charAt(i)*Math.pow(10,i+1);
//        }
//        hashcode=hashcode%maxSize;
//        return hashcode;
        }



    // Method 7
    // Function to insert value
    public void insert(String value) {
    int tmp = hash(value);
    int i = tmp;
    Node Node = nodes[i];
    if(Node==null){
        nodes[i]=new Node(value,null);
    }
    else{
        while(Node.nextNode!=null){
//            if(Node.nextNode.equals(value)){
//                System.out.println("The value has been exsited:");
//                return;
//            }
         Node = Node.nextNode;
        }

        nodes[i].nextNode = new Node(value,null);

    }
    currentSize++;
    }



    // Method 8

    // Function to get value for the given key
    public String get(String key)
    {
        int tmp = hash(key);
        int i = tmp;
        Node CurrentNode=nodes[i];
        if(CurrentNode!=null){
            while(!CurrentNode.value.equals(key)){
                CurrentNode = CurrentNode.nextNode;
                if(CurrentNode==null){
                    return null;
                }
            }
            return CurrentNode.value;

        }
        else{
            System.out.println("This key is not founded");
            return null;
        }


    }

    // Method 9
    // Function to remove the value
    public void remove(String value) {
        int tmp = hash(value);
        int i = tmp;
        Node CurrentNode = nodes[i];
        if (CurrentNode != null) {
            if (CurrentNode.value.equals(value)) {
                nodes[i] = CurrentNode.nextNode;
                currentSize--;
                return;
            } else {
                while (CurrentNode.nextNode!=null) {
                    if(CurrentNode.nextNode.value.equals(value)){
                        CurrentNode.nextNode = CurrentNode.nextNode.nextNode;
                        currentSize--;
                        return;
                    }
                        CurrentNode = CurrentNode.nextNode;
                }

            }
        }
        System.out.println("There is no value in node needing to remove!");
    }


    // Method 10
    // Function to print the whole HashTable
    public void printHashTable() {
        System.out.println("\nHash Table: ");
        for(int i=0; i<maxSize; i++){
            Node node = nodes[i];
            if(node==null){
                System.out.print(i+" null");
            }
            while(node!=null){
                System.out.print(i+" "+node.value);
                if(node.nextNode!=null){
                System.out.print("->");
                }
                node=node.nextNode;
            }
            System.out.print("\n");
        }
        System.out.println("Load factor: "+(double)currentSize/maxSize*100+"%");
    }
}
