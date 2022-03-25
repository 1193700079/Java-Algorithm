package 数据结构之图.练习题;

/**
 * @program: lanqiaobei2020
 * @description:
 * dfs+动态标记+回缩
 * @author: yrq
 * @create: 2020-02-26 18:34
 **/
//加上判断有向图是否有环
public class Test3_拓扑排序 {
    static int[][] a=new int[][]{
            {0,1,0,0},
            {0,0,1,0},
            {0,1,0,0},
            {0,0,1,0},
    };
    static int n = 4;
    static int[] vis = new int[n];  //1.表示已经排序完毕了  0表示从未访问过 -1表示正在递归中还没有进入（说明有环）
    static int[] topo = new int[n];
    static int topoIndex = n;
    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {

            if(vis[i] == 1) continue;

            boolean bool = dfs(i);

            if(bool == false) {
                System.out.println("有环的存在 不能进行拓扑排序");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(topo[i]);
        }
    }

    private static boolean dfs(int i) {
        vis[i] = -1;

        for (int j = 0; j < n; j++) {
            if(a[i][j]==1){
                //表示上一层循环的时候标记过了 说明有环
                if(vis[j]==-1) return false;

                //如果该点没有被访问  就继续dfs到这个点  把j理解为列上的点
                if(vis[j]==0 && dfs(j)==false) return false;
            }
        }

        topo[--topoIndex] = i;
        vis[i] = 1;
        return true;
    }
}
