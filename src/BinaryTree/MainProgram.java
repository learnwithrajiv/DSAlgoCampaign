package BinaryTree;

public class MainProgram {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("\n\nBinary Tree: Pre Order Traversal");
        BinaryTreeTraversalUtil.PreOrderTraversal(root);

        System.out.println("\n\nBinary Tree: In Order Traversal");
        BinaryTreeTraversalUtil.InOrderTraversal(root);

        System.out.println("\n\nBinary Tree: Post Order Traversal");
        BinaryTreeTraversalUtil.PostOrderTraversal(root);

//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);
//        root1.left.left = new TreeNode(4);
//        root1.left.right = new TreeNode(5);
//        root1.left.left.left = new TreeNode(6);
//        root1.left.right.right = new TreeNode(7);
//        root1.right.right = new TreeNode(8);
//        root1.right.right.right = new TreeNode(9);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);

        System.out.println("\n\nBinary Tree: Level Order Traversal");
        BinaryTreeTraversalUtil.LevelOrderTraversal(root1);

        System.out.println("\n\nBinary Tree: Left View");
        BinaryTreeTraversalUtil.LeftView(root1);

        System.out.println("\n\nBinary Tree: Right View");
        BinaryTreeTraversalUtil.RightView(root1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.left.right.left = new TreeNode(17);
        root2.left.right.left.left = new TreeNode(18);
        root2.left.right.right = new TreeNode(6);
        root2.right.left = new TreeNode(18);
        root2.right.right = new TreeNode(7);
        root2.right.right.right = new TreeNode(8);

        System.out.println("\n\nBinary Tree: Spiral Level Order Traversal");
        BinaryTreeTraversalUtil.SpiralLevelOrderTraversal(root2);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(6);
        root3.right.right = new TreeNode(7);
        root3.right.left.right = new TreeNode(8);

        System.out.println("\n\nBinary Tree: Vertical Order Traversal");
        BinaryTreeTraversalUtil.VerticalOrderTraversal_SpaceComplexityN(root3);

        System.out.println("\nBinary Tree: Top View");
        BinaryTreeTraversalUtil.TopView(root3);

        System.out.println("\n\nBinary Tree: Bottom View");
        BinaryTreeTraversalUtil.BottomView(root3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(6);
        root4.left.left = new TreeNode(3);
        root4.left.right = new TreeNode(4);
        root4.left.right.right = new TreeNode(5);
        root4.left.right.right.right = new TreeNode(7);
        root4.left.right.right.right.right = new TreeNode(8);

        System.out.println("\n\nHeight of Binary Tree: " + BinaryTreeTraversalUtil.HeightOfBinaryTree(root4));
        System.out.println("\nTotal Nodes in a Binary Tree: " + BinaryTreeTraversalUtil.TotalNodeCount(root4));

        TreeNode root5 = new TreeNode(1);
        root5.left = new TreeNode(2);
        root5.right = new TreeNode(3);
        root5.left.left = new TreeNode(4);
        root5.left.right = new TreeNode(5);
        root5.left.right.right = new TreeNode(6);
        root5.right.right = new TreeNode(7);
        root5.right.right.right = new TreeNode(8);

        System.out.println("\n\nBinary Tree: Boundary Traversal");
        BinaryTreeTraversalUtil.BoundaryTraversal(root5);

        System.out.println("\n\nBinary Tree: Mirror of tree");
        System.out.print("BEFORE: ");
        BinaryTreeTraversalUtil.InOrderTraversal(root5);
        BinaryTreeTraversalUtil.MirrorOfBinaryTree(root5);
        System.out.print("\nAFTER: ");
        BinaryTreeTraversalUtil.InOrderTraversal(root5);

    }
}
