package cn.tedu.mybatis.param;

public class TestParam {

    // 定义一个可变参数的方法
    // static只是为了方便调用
    /*
        方法定义时:
        1.每个方法只能定义一个可变参数,而且这个可变参数必须是最后一个参数
        2.定义的方法体中将可变参数视为一个数组来处理即可
     */
    public static void sum(int... nums){
        int sum=0;    //假设:  nums:{3,4,6}
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        System.out.println(sum);
    }
    //可变参数方法的调用
    public static void main(String[] args) {
        /*
        调用可变参数方法
        1.可以连续赋值多个类型符合的值
        2.传入的参数数量不限(0~无数)
        3.可以传入类型匹配的数组类型对象(只能传一个数组)
         */
        sum(3,4,6);
        sum();
        int[] n={7,6,9,1,2,4};
        sum(n);

    }
}
