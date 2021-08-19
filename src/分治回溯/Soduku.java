package 分治回溯;

import java.util.Scanner;

public class Soduku {
    public static void main(String[] args) {
        int[][] board= new int[ 9 ][9];
        System.out.println("输入数独题目：");
        Scanner scanner= new Scanner(System.in);
        for(int i=0;i<board.length;i++){
            String line=scanner.nextLine();
            for(int j=0;j<board.length;j++){
                board[i][j]=Integer.parseInt(line.charAt(j)+" ");
            }
        }
        solve(0,0,board);
    }

    private static void solve(int row, int col, int[][] board) {
        if(row==9){
            print(board);
            return;
        }else{

            if(board[row][col]==0){//没有数字，需要计算填写什么数字
                for(int num=0;num<=9;num++){
                    if(!isExist(row,col,num,board)){
                        board[row][col]=num;
                        solve(row+(col+1)/ 9,(col+1)% 9,board);
                    }
                    board[row][col]=0;//清零
                }

            }else{//有数字，下一个数字开始重新计算
                solve(row+(col+1)/ 9,(col+1)% 9,board);
            }
        }
    }

    //(row,col)处如果填入num值，这是否冲突
    private static boolean isExist(int row, int col, int num, int[][] board) {
        //行
        for(int c=0;c<9;c++){
            if(board[row][c]==num){
                return true;
            }
        }
        //列
        for(int r=0;r<9;r++){
            if(board[r][col]==num){
                return true;
            }
        }
        //小方格
        int rowMin=0;
        int colMin=0;
        int rowMax=0;
        int colMax=0;
        if(row>=0 &&row<=2){
            rowMin=0;
            rowMax=2;
        }
        if(row>=3 &&row<=5){
            rowMin=3;
            rowMax=5;
        }

        if(row>=6 &&row<=8){
            rowMin=6;
            rowMax=8;
        }

        if(col>=0&& col<=2){
            colMin=0;
            colMax=2;
        }

        if(col>=3&& col<=5){
            colMin=3;
            colMax=5;
        }
        if(col>=6&& col<=8){
            colMin=6;
            colMax=8;
        }
        for(int r=rowMin;r<=rowMax;r++){
            for(int c=colMin;c<colMax;c++){
                if(board[r][c]==num){
                    return true;
                }
            }
        }
        return false;
    }

    private static void print(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
