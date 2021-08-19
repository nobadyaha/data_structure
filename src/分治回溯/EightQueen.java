package 分治回溯;

public class EightQueen {
    //解的编号
    private static int count=0;
    //棋盘尺寸
    private static final int SIZE=4;

    public static void main(String[] args) {
        int[][] arr= new int[SIZE][SIZE];
        eightQueen(0,arr);

    }

    private static void eightQueen(int row, int[][] arr) {
        if(row==SIZE){
            count++;
            System.out.println("THIS IS "+count+"th method");
            print(arr);
        }else{
            int[][] newArr=copyOf(arr);
            for(int col=0;col<SIZE;col++){
                if(noDangers(row,col,newArr)){
                    for(int c=0;c<SIZE;c++) {
                        newArr[row][c] = 0;
                    }
                    newArr[row][col] = 1;
                    eightQueen(row+1,newArr);
                }

            }

        }
    }

    private static boolean noDangers(int row, int col, int[][] arr) {
        //正上方
        for(int r=row-1;r>=0;r--){
            if(arr[r][col] == 1){
                return false;
            }
        }
        //左上方
        for (int r=row-1,c=col-1;r>=0 && c>=0;r--,c--){
            if(arr[r][c]==1){
                return false;
            }
        }
        //右上方
        for(int r=row-1,c=col+1;r>=0&&c<SIZE;r--,c++){
            if(arr[r][c]==1){
                return false;
            }
        }
        return true;
    }

    private static int[][] copyOf(int[][] arr) {
        int[][] newArr=new int[SIZE][SIZE];
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    private static void print(int[][] arr) {
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
