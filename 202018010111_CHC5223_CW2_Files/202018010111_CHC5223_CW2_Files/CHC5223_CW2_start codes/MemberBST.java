package CHC5223;

public class MemberBST implements IMemberDB {
    private class Node {
        Member member;
        Node left;
        Node right;

        Node(Member member) {
            this.member = member;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;


    public MemberBST() {
        root = null;
        size = 0;
        System.out.println("Binary Search Tree");
    }

    @Override

    public Member put(Member member) {
        assert member != null : "Member should not be null";
        assert !member.getName().isEmpty() : "Member name should not be empty";
        System.out.print("Adding member: " + member.getName());
        System.out.print(", Node visited: ");
        root = put(root, member);
        System.out.println();
        return null;
    }


    private Node put(Node node, Member member) {
        // edge judge
        if (node == null) {
            size++;
            return new Node(member);
        }

        System.out.print(node.member.getName() + " ");
        // member vs node->member
        int cmp = member.getName().compareTo(node.member.getName());

        // member < node->member, put to left
        if (cmp < 0) {
            if (node.left != null && member.getName().equals(node.left.member.getName())) {
                System.out.println("Duplicate member found: " + member.getName());
            }
            node.left = put(node.left, member);
        }
        // member > node->member, put to right
        else if (cmp > 0) {
            if (node.right != null && member.getName().equals(node.right.member.getName())) {
                System.out.println("Duplicate member found: " + member.getName());
            }
            node.right = put(node.right, member);
        }
        // member == node->member, ok
        else {
            node.member = member;
        }
        return node;
    }

    public Member get(String name) {
        assert name != null && !name.trim().isEmpty() : "Name to be gotten should not be null or empty";
        System.out.print("Getting member: " + name);
        System.out.print(", Node visited: ");
        Node node = get(root, name);
        System.out.println();
        return node == null ? null : node.member;
    }

    private Node get(Node node, String name) {
        if (node == null) {
            return null;
        }
        System.out.print(node.member.getName() + " ");
        int cmp = name.compareTo(node.member.getName());
        if (cmp < 0) {
            return get(node.left, name);
        } else if (cmp > 0) {
            return get(node.right, name);
        } else {
            return node;
        }
    }


    public Member remove(String name) {
        assert name != null && !name.isEmpty() : "Name to be removed should not be null or empty";

        Node parent = null, del, p = null, q = null;
        Member result;
        del = root;
        while (del != null && !del.member.getName().equals(name)) {
            parent = del;
            if (name.compareTo(del.member.getName()) < 0)
                del = del.left;
            else
                del = del.right;
        }

        if (del != null) {
            if (del == root) {
                System.out.println("Removing member: " + name + ", Node visited: " + del.member.getName());
                System.out.println("(This deleted node is the root node and the node visited is itself)");
            } else {
                System.out.println("Removing member: " + name + ", Node visited: " + del.member.getName());
            }

            if (del.right == null) p = del.left;
            else if (del.right.left == null) {
                p = del.right;
                p.left = del.left;
            } else {
                p = del.right;
                while (p.left != null) {
                    q = p;
                    p = p.left;
                }
                q.left = p.right;
                p.left = del.left;
                p.right = del.right;
            }

            if (del == root) root = p;
            else if (del.member.getName().compareTo(parent.member.getName()) < 0)
                parent.left = p;
            else
                parent.right = p;

            result = del.member;
        } else {
            System.out.println("Node not found");
            result = null;
        }
        size--;
        return result;
    }

    //
//Use for show member in alphabetical order
    public void displayDB() {
        if (root == null) {
            System.out.println("The database is empty.");
            return;
        }

        System.out.println("Members in alphabetical order:");
        displayInOrder(root);
    }

    private void displayInOrder(Node node) {
        if (node != null) {
            displayInOrder(node.left);
            System.out.println("Name: " + node.member.getName() + ", Affiliation: " + node.member.getAffiliation());
            displayInOrder(node.right);
        }
    }


    public boolean containsName(String name) {
        assert name != null && !name.trim().isEmpty() : "Name to be searched should not be null or empty";
        return containsName(name, root);
    }

    private boolean containsName(String name, Node node) {
        if (node == null) {
            return false;
        }

        int compare = name.compareTo(node.member.getName());
        if (compare < 0) {
            return containsName(name, node.left);
        } else if (compare > 0) {
            return containsName(name, node.right);
        } else {
            return true;
        }
    }


    public void clearDB() {
        root = null;
        size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


//This display method is used to showed the structure of tree
//    public void displayDB() {
//        if (root == null) {
//            System.out.println("The database is empty.");
//            return;
//        }
//
//        System.out.println("Members showed in tree model");
//        displayInOrder(root, "");
//    }
//
//    private void displayInOrder(Node node, String prefix) {
//        if (node != null) {
//            displayInOrder(node.right, prefix + "    ");
//
//            if (node.right != null) {
//                System.out.println(prefix + " /");
//            }
//
//            System.out.println(prefix + node.member.getName() + ", " + node.member.getAffiliation());
//
//            if (node.left != null) {
//                System.out.println(prefix + " \\");
//            }
//
//            displayInOrder(node.left, prefix + "    ");
//        }
//    }
}

