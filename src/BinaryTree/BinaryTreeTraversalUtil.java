package BinaryTree;

import java.util.*;

public class BinaryTreeTraversalUtil {

    public static void PreOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreOrderTraversal(root.left);
        PreOrderTraversal(root.right);
    }

    public static void InOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        InOrderTraversal(root.left);
        System.out.print(root.data + " ");
        InOrderTraversal(root.right);
    }

    public static void PostOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        PostOrderTraversal(root.left);
        PostOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void LevelOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.remove(0);
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
    }

    public static void LeftView (TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            int queueCount = queue.size();
            while (count > 0) {
                TreeNode node = queue.remove(0);
                if (count == queueCount) {
                    System.out.print(node.data + " ");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
    }

    public static void RightView (TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int count = queue.size();
            while (count > 0) {
                TreeNode node = queue.remove(0);
                if (count == 1) {
                    System.out.print(node.data + " ");
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                count--;
            }
        }
    }

    public static void SpiralLevelOrderTraversal (TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (stack1.size() > 0 || stack2.size() > 0) {
            while (stack1.size() > 0) {
                TreeNode node = stack1.pop();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            System.out.println();
            while (stack2.size() > 0) {
                TreeNode node = stack2.pop();
                System.out.print(node.data + " ");
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            System.out.println();
        }
    }

    static class VOT_Obj {
        public TreeNode node;
        public int dis;

        VOT_Obj(TreeNode node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }

    public static void VerticalOrderTraversal_SpaceComplexityN (TreeNode root) {
        if (root == null) {
            return;
        }
        Map<Integer, List<TreeNode>> distMap = new TreeMap<>();
        List<VOT_Obj> queue = new ArrayList<>();
        queue.add(new VOT_Obj(root, 0));

        while (queue.size() > 0) {
            VOT_Obj obj = queue.remove(0);
            if (distMap.containsKey(obj.dis)) {
                distMap.get(obj.dis).add(obj.node);
            } else {
                List<TreeNode> nodeObj = new ArrayList<>();
                nodeObj.add(obj.node);
                distMap.put(obj.dis, nodeObj);
            }

            if (obj.node.left != null) {
                queue.add(new VOT_Obj(obj.node.left, obj.dis - 1));
            }
            if (obj.node.right != null) {
                queue.add(new VOT_Obj(obj.node.right, obj.dis + 1));
            }
        }
        for (Integer key : distMap.keySet()) {
            List<TreeNode> nodeList = distMap.get(key);
            for (TreeNode node : nodeList) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    public static void TopView (TreeNode root) {
        if (root == null) {
            return;
        }
        Map<Integer, TreeNode> distMap = new TreeMap<>();
        List<VOT_Obj> queue = new ArrayList<>();
        queue.add(new VOT_Obj(root, 0));
        while (queue.size() > 0) {
            VOT_Obj obj = queue.remove(0);
            if (!distMap.containsKey(obj.dis)) {
                distMap.put(obj.dis, obj.node);
            }

            if (obj.node.left != null) {
                queue.add(new VOT_Obj(obj.node.left, obj.dis-1));
            }
            if (obj.node.right != null) {
                queue.add(new VOT_Obj(obj.node.right, obj.dis+1));
            }
        }
        for (Integer key : distMap.keySet()) {
            System.out.print(distMap.get(key).data + " ");
        }
    }

    public static void BottomView (TreeNode root) {
        if (root == null) {
            return;
        }
        Map<Integer, TreeNode> distMap = new TreeMap<>();
        List<VOT_Obj> queue = new ArrayList<>();
        queue.add(new VOT_Obj(root, 0));
        while (queue.size() > 0) {
            VOT_Obj obj = queue.remove(0);
            distMap.put(obj.dis, obj.node);

            if (obj.node.left != null) {
                queue.add(new VOT_Obj(obj.node.left, obj.dis-1));
            }
            if (obj.node.right != null) {
                queue.add(new VOT_Obj(obj.node.right, obj.dis+1));
            }
        }
        for (Integer key : distMap.keySet()) {
            System.out.print(distMap.get(key).data + " ");
        }
    }

    public static int HeightOfBinaryTree (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(HeightOfBinaryTree(root.left), HeightOfBinaryTree(root.right)) + 1;
    }

    public static int TotalNodeCount (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (TotalNodeCount(root.left) + TotalNodeCount(root.right) + 1);
    }

    public static void BoundaryTraversal (TreeNode root) {
        PrintLeftNodeWithoutLeafNode(root);
        PrintLeafNodes(root);
        PrintRightNodeWithoutLeafNode(root.right);
    }

    private static void PrintLeftNodeWithoutLeafNode (TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            PrintLeftNodeWithoutLeafNode(root.left);
        }
    }

    private static void PrintLeafNodes (TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        } else {
            PrintLeafNodes(root.left);
            PrintLeafNodes(root.right);
        }
    }

    private static void PrintRightNodeWithoutLeafNode (TreeNode root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            return;
        } else {
            PrintRightNodeWithoutLeafNode(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void MirrorOfBinaryTree (TreeNode root) {
        if (root == null) {
            return;
        }
        MirrorOfBinaryTree (root.left);
        MirrorOfBinaryTree (root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}