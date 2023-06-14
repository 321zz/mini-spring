package org.springframework.beans.factory.support;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.ObjectFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 储晓波
 * @date 2023/6/14 10:00
 * @desc
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry{

    // 一级缓存
    private Map<String,Object> singletonObjects = new HashMap<>();

    // 二级缓存
    private Map<String,Object> earlySingletonObjects = new HashMap<>();

    // 三级缓存
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();


    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if(singletonObject == null){
            singletonObject = earlySingletonObjects.get(beanName);
            if(singletonObject == null){
                ObjectFactory<?> objectFactory = singletonFactories.get(beanName);
                if(objectFactory != null){
                    singletonObject = objectFactory.getObject();
                    //从三级缓存放进二级缓存
                    earlySingletonObjects.put(beanName,singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName,singletonObject);
        earlySingletonObjects.remove(beanName);
        disposableBeans.remove(beanName);
    }

    protected void addSingletonFactory(String beanName,ObjectFactory<?> singletonFactory){
        singletonFactories.put(beanName,singletonFactory);
    }

    protected void registerDisposableBean(String beanName, DisposableBean bean){
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        for(String beanName : beanNames){
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try{
                disposableBean.destory();
            }catch (Exception e){
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
