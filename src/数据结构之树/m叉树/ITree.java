package 数据结构之树.m叉树;


public interface ITree<T> {
    int getSize(); //得到树的节点数
    int getHeight(TreeNode<T> x); //得到树的高度  注意是向下
    TreeNode<T> getRoot();//得到根节点
    TreeNode<T> getParent(TreeNode<T> x);  //得到父节点
    TreeNode<T> getFirstChild(TreeNode<T> x); //得到第一个儿子节点
    TreeNode<T> getNextBrother(TreeNode<T> x); //得到下一个兄弟节点
    void insertChild(TreeNode<T> father,TreeNode<T> son);
    void deleteChild(TreeNode<T> father,int i); //删掉第几个儿子节点
    //先序遍历
    void preOrder(TreeNode<T> head);
    //后序遍历
    void postOrder(TreeNode<T> head);
    //层序遍历 bfs
    void levelOrder(TreeNode<T> head);
}
