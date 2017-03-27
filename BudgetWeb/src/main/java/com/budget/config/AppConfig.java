package com.budget.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * 系统配置信息
 *
 * Created by chao.zhao on 2017/3/13.
 */
public class AppConfig {
    // 定义私有构造方法（防止通过 new AppConfig()去实例化）
    private AppConfig() {
    }

    private Config config =  ConfigFactory.load() ;//默认获取application.*的配置文件

    private Config root = config.getConfig("main") ;

    // AppConfig（不初始化，注意这里没有使用final关键字）
    private static AppConfig instance;

    // 定义一个静态的方法（AppConfig，但是多线程访问时，可能造成重复初始化问题）
    public static AppConfig getInstance() {
        if (instance == null)
            instance = new AppConfig();
        return instance;
    }

    /**
     *
     * @param key key
     * @return value
     */
    public String getElement(String key){
       return this.root.getString(key) ;
    }

    /**
     *
     * @param subBoot 子节点
     * @param key key
     * @return value
     */
    public String getSubElemnet(String subBoot,String key){
       return this.root.getConfig(subBoot).getString(key) ;
    }

    /**
     * 根据路径获取配置
     *
     * @param root 根
     * @param key key
     * @return vallue
     */
    public String getElementByPath(String root,String key){
        Config conf = config.getConfig(root) ;
        return conf.getString(key) ;
    }

    public static void main(String[] args) {
        String str = AppConfig.getInstance().getElementByPath("sub","key1");
        System.out.println(str);
    }
}
