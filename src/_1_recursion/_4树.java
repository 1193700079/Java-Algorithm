package _1_recursion;

public class _4树 {
    /**
     * 先序遍历
     * @param arr
     * @param i
     */
    private static void preOrder(int[] arr, int i) {
        if(i>=arr.length){
            return;
        }else {
            System.out.print(arr[i]+" ");
            preOrder(arr,2*i+1);  //左子树
            preOrder(arr,2*i+2);  //右子树
        }

    }

    /**
     * 中序遍历
     * @param arr
     * @param i
     */
    private static void inOrder(int[] arr, int i) {
        if(i>=arr.length){
            return;
        }else {
            preOrder(arr,2*i+1);  //左子树
            System.out.print(arr[i]+" ");
            preOrder(arr,2*i+2);  //右子树
        }

    }
    public static void main(String[] args) {
        int[] arr= new int[]{78,56,34,43,4,1,15,2,23};
        preOrder(arr,0);
        System.out.println();
    }

}
