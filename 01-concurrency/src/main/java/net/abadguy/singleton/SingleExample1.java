package net.abadguy.singleton;

/**
 * 懒汉模式
 * 单例实例在第一次使用是进行创建
 * 这样写是线程不安全的
 */
public class SingleExample1 {

    //私有构造方法
    private SingleExample1(){

    }
    //单例对象
    private static SingleExample1 instance=null;
    //静态工厂方法（该方法在单线程模式下使用没有问题，但是在多线程情况下会出现问题，可能会创建多个实例）
    public static SingleExample1 getInstance(){
        if(instance == null){
            instance=new SingleExample1();
        }
        return instance;
    }
}
