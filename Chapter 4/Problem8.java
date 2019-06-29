import structures.Tree;

import java.util.stream.IntStream;

public class Problem8 {
    public static void main(String[] args) {
        Tree tree = new Tree(IntStream.range(1, 16).toArray());

        Tree t1 = tree.getLeft().getLeft().getLeft();
        Tree t2 = tree.getRight().getRight();

        Tree t3 = tree.getLeft().getLeft().getLeft();
        Tree t4 = tree.getLeft().getRight();

        Tree t5 = tree.getLeft().getLeft().getLeft();
        Tree t6 = tree.getLeft().getLeft().getRight();

        System.out.println(firstCommonAncestor(t1, t2));
        System.out.println(firstCommonAncestor(t3, t4));
        System.out.println(firstCommonAncestor(t5, t6));
    }

    private static Tree firstCommonAncestor(Tree t1, Tree t2) {
        int d1 = getDepth(t1);
        int d2 = getDepth(t2);
        if (d1 != d2) {
            int diff = d1 - d2;
            if (diff < 0) {
                while (diff != 0) {
                    t2 = t2.getParent();
                    diff++;
                }
            } else {
                while (diff > 0) {
                    t1 = t1.getParent();
                    diff--;
                }
            }
        }

        while (t1 != t2 && t1.getParent() != null) {
            t1 = t1.getParent();
            t2 = t2.getParent();
        }

        return t1;
    }

    private static int getDepth(Tree t) {
        int depth = 0;
        while (t.getParent() != null) {
            t = t.getParent();
            depth++;
        }
        return depth;
    }
}
