package org.springframework.beans.factory.support;

/**
 * @author 储晓波
 * @date 2023/6/14 9:58
 * @desc 单例注册表
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

    void addSingleton(String beanName,Object singletonObject);
}
