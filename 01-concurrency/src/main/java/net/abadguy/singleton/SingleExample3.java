package net.abadguy.singleton;

/**
 * 懒汉模式－线程安全
 * 单例实例在第一次使用是进行创建
 * 不推介
 *
 */
public class SingleExample3 {

    //私有构造方法
    private SingleExample3(){

    }
    //单例对象
    private static SingleExample3 instance=null;
    //静态工厂方法(添加synchronized关键字保证线程安全)
    public static synchronized SingleExample3 getInstance(){
        if(instance == null){
            instance=new SingleExample3();
        }
        return instance;
    }
}
