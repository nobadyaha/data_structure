package 分治回溯;

import java.util.Scanner;

public class ChessboardCoverage {
    //棋盘尺寸
    private static int BOARD_SIZE=8;
    //虚拟棋盘
    private static int[][] board=new int [BOARD_SIZE][BOARD_SIZE];
    //骨牌编号
    private static int title=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("棋盘大小为："+BOARD_SIZE);
        System.out.println("请输入特殊方格的行号：");
        int dr=scanner.nextInt();
        System.out.println("请输入特殊方格的列号：");
        int dc=scanner.nextInt();
        chessBorad(0,0,dr-1,dc-1,BOARD_SIZE);
        print();
    }
    //tr tc 某一个方形的左上角坐标（tr,tc);
    //dr dc 特殊方格坐标

    private static void chessBorad(int tr, int tc, int dr, int dc, int size) {

        if(size==1){
            return;
        }
        //当前层级下骨牌的编号
        //同一个L型的格子有相同的编号，特殊格子的编号为0
        int num= ++title;
        //分成4块
        int s=size/2;
        //1、左上角子方格
        if(dr<tr+s && dc<tc+s){
            chessBorad(tr,tc,dr,dc,s);
        }else{
            board [tr+s-1][tc+s-1]=num;
            chessBorad(tr,tc,tr+s-1,tc+s-1,s);
        }
        //2、右上角子方格
        if(dr<tr+s && dc>=tc+s){
            chessBorad(tr,tc+s,dr,dc,s);
        }else{
            board[tr+s-1][tc+s]=num;
            chessBorad(tr,tc+s,tr+s-1,tc+s,s);
        }

        //3、左下角子方格
        if(dr>=tr+s && dc<tc+s){
            chessBorad(tr+s,tc,dr,dc,s);
        }else{
            board[tr+s][tc+s-1]=num;
            chessBorad(tr+s,tc,tr+s,tc+s-1,s);
        }

        //4、右下角子方格
        if(dr>=tr+s && dc>=tc+s){
            chessBorad(tr+s,tc+s,dr,dc,s);
        }else{
            board[tr+s][tc+s]=num;
            chessBorad(tr+s,tc+s,tr+s,tc+s,s);
        }
    }
    private static void print(){
        for(int i=0; i<BOARD_SIZE;i++){
            for(int j=0;j<BOARD_SIZE;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
