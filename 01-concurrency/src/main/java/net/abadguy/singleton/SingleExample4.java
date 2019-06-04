package net.abadguy.singleton;

/**
 * 懒汉模式－双重同步锁单例模式
 * 单例实例在第一次使用是进行创建
 * 线程不安全
 *
 */
public class SingleExample4 {

    //私有构造方法
    private SingleExample4(){

    }
    //单例对象
    private static volatile SingleExample4 instance=null;
    //静态工厂方法
    public static SingleExample4 getInstance(){
        if(instance == null){//双重检测机制
            synchronized (SingleExample4.class){//同步锁
                if(instance == null){
                    instance=new SingleExample4();
                }
            }
        }
        return instance;
    }
}
