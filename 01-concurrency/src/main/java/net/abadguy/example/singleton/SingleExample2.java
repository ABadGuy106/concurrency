package net.abadguy.example.singleton;

/**
 * 饿汉模式
 * 单例实例在类装载的时候进行创建
 * 这个是线程安全的
 */
public class SingleExample2 {

    //私有构造方法
    private SingleExample2(){

    }
    //单例对象
    private static SingleExample2 instance=instance=new SingleExample2();
    //静态工厂方法
    public static SingleExample2 getInstance(){
        return instance;
    }
}
