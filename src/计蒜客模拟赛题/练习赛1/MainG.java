package 计蒜客模拟赛题.练习赛1;

import java.util.Scanner;

/**
 * @program: lanqiaobei2020
 * @description: 类似一个游戏题 丢炸弹
 * 没有考虑炸弹炸出去的情况
 * 主要看题是否要开long
 * @author: yrq
 * @create: 2020-01-18 14:04
 **/
public class MainG {
    static int a,b,c;
    static int n,m;
    static int shRoad,shHouse,shField;
    static int k,w;
    static int[][] shanghaiTable;
    static int[][] cunzhuangNaijiuDu;
    static int[] idx;   //1表示普通炮弹 0表示高级炮弹
    static int[] x;//x,y表示攻击的坐标
    static int[] y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   //村庄大小
        m = sc.nextInt();
        int cunzhuangS[][] = new int[n][m];


        a = sc.nextInt();   //表示道路 房屋 田地耐久度
        b = sc.nextInt();
        c = sc.nextInt();

        k = sc.nextInt();  //炮弹的攻击范围 以及炮弹的伤害  3
        w = sc.nextInt();  //高级炮弹的溅射伤害

        shanghaiTable = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                shanghaiTable[i][j]=sc.nextInt();
            }
        }

        cunzhuangNaijiuDu=new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //输入的是
                cunzhuangS[i][j]=sc.nextInt();
                if(cunzhuangS[i][j]==1){
                    //如果存放的是道路
                    cunzhuangNaijiuDu[i][j]=a;
                }else if(cunzhuangS[i][j]==2){
                    cunzhuangNaijiuDu[i][j]=b;
                }else {
                    cunzhuangNaijiuDu[i][j]=c;
                }
            }
        }

        int q = sc.nextInt();  //攻击次数
        idx=new int[q];   //1表示普通炮弹 0表示高级炮弹
        x=new int[q];//x,y表示攻击的坐标
        y=new int[q];
        for (int i = 0; i < q; i++) {
            idx[i]=sc.nextInt();
            x[i]=sc.nextInt()-1;
            y[i]=sc.nextInt()-1;
        }

        //计算伤害
        shRoad=0;
        shHouse=0;
        shField=0;

        for (int i = 0; i < q; i++) {
            if(x[i]>=n||y[i]>=m){
                //说明炸出去了
                break;
            }
            //都先按照普通炮弹处理
            //分析击中的范围
            //伤害范围的偏移量

            int offset = (k-1)/2;
            for (int j = x[i]-offset; j <=x[i]+offset&& j<n; j++) {
                for (int l = y[i]-offset; l <=y[i]+offset&& l<m; l++) {
                    if(j<0||l<0){
                        continue;
                    }
                    int pot = cunzhuangS[j][l]; //判断打到的点是什么建筑
                    //这个点所造成的伤害 根据伤害表推算出来
                    int shanghai = shanghaiTable[j-x[i]+offset][l-y[i]+offset];
                    jisuanSHGj(pot,shanghai,j,l);
                }
            }
            if(idx[i]==0){
                //高级炮弹
                int jsoffset=1;
                for (int j = x[i]-jsoffset; j <=x[i]+jsoffset&& j<n; j++) {
                    for (int l = y[i] - jsoffset; l <= y[i] + jsoffset&& l<m; l++) {
                        if(j==x[i]&&l==y[i]){  //炮弹中心点伤害不计算
                            continue;
                        }else {
                            if(j<0||l<0){
                                continue;
                            }
                            int pot = cunzhuangS[j][l]; //判断是什么建筑 打到的点
                            jisuanSHGj(pot,w,j,l);
                        }
                    }
                }
            }
        }
        int shSum=shRoad+shHouse+shField;
        System.out.println(shRoad+" "+shHouse+" "+shField);
        System.out.println(shSum);
    }

    /**
     * 高级炮弹的计算方法
     * @param pot
     * @param i
     */
    private static void jisuanSHGj(int pot,int w,int i,int j) {

        int najiudu = cunzhuangNaijiuDu[i][j];
        if (najiudu <= 0) {
            return;
        }
        if (pot == 1) {
            if (w > najiudu) {
                shRoad += najiudu;
                cunzhuangNaijiuDu[i][j] = 0;
            } else {
                shRoad += w;
                cunzhuangNaijiuDu[i][j] -= w;
            }
        } else if (pot == 2) {
            if (w > najiudu) {
                shHouse += najiudu;
                cunzhuangNaijiuDu[i][j] = 0;
            } else {
                shHouse += w;
                cunzhuangNaijiuDu[i][j] -= w;
            }
        } else {
            if (w > najiudu) {
                shField += najiudu;
                cunzhuangNaijiuDu[i][j] = 0;
            } else {
                shField += w;
                cunzhuangNaijiuDu[i][j] -= w;
            }
        }
    }

}
