package 分治回溯;

public class Recursion {
    public static void main(String[] args) {
        test01();//递归累加
        test02();//迭代累加
       test03();//递归阶乘
        test04();//迭代阶乘
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
