package 分治回溯;

public class BigIntegerMultiplication {
    public static void main(String[] args) {
        long x=123456778;
        long y=12345678;
        long product=multi(x,y,3);
        System.out.println(product);
    }

    private static long multi(long x, long y, int n) {
        if(x==0 || y==0){
            return 0;
        }
        if(n==1){
            return x * y;
        }
        long A= (long) (x/Math.pow(10,n/2));
        long B= (long) (x-A*Math.pow(10,n/2));
        long C= (long) (y/A*Math.pow(10,n/2));
        long D= (long) (y-C*Math.pow(10,n/2));
        long E=multi(A,C,n/2);
        long F=multi(B,D,n/2);
        long G=multi(A+B,C+D,n/2);
        return (long) (E*Math.pow(10,n)+(G-E-F)*Math.pow(10,n/2)+F);
    }

    public static class Recursion {
        public static void main(String[] args) {
            test01();//递归累加
            test02();//迭代累加
            test03();//递归阶乘
            test04();//迭代阶乘
            test05();//递归斐波那契
            test06();//迭代斐波那契

        }

        private static void test06() {
            int n=45;
            int num=getFabonacci(n);
            System.out.println(num);
        }

        private static int getFabonacci(int n) {
            if(n==1 || n==2){
                return 1;
            }
            int first=1;
            int second=1;
            int current=0;
            for(int i=3;i<=n;i++){
                current=first+second;
                first=second;
                second=current;
            }
            return current;
        }

        private static void test05() {
            int n=45;
            int num=fabonacci(n);
            System.out.println(num);
        }

        private static int fabonacci(int n) {
            if(n==1 || n==2){
                return 1;
            }
            return fabonacci(n-1)+fabonacci(n-2);
        }

        private static void test04() {
            int n=10;
            int product=1;
            for(int i=1;i<=n;i++){
                product *=i;
            }
            System.out.println(product);
        }

        private static void test03() {
            int n=10;
            int product=factorial(n);
            System.out.println(product);
        }

        private static int factorial(int n) {
            if(n==1){
                return 1;
            }
            return factorial(n-1)*n;
        }

        private static void test02() {
            int sum=0;
            int n=100;
            for(int i=1;i<=n;i++){
                sum+=i;
            }

            System.out.println(sum);
        }

        private static void test01() {
            int n=100;
            int sum = sum(n);
            System.out.println(sum);
        }
        private static int sum(int n){
            if(n==1){
                return 1;
            }//边界条件
            return sum(n-1)+n;
        }
    }
}