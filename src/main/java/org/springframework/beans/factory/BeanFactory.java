package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author 储晓波
 * @date 2023/6/14 9:47
 * @desc bean容器
 */
public interface BeanFactory {

    /**
     * 返回容器中id为name的bean实例
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 返回容器中id为name并且属于requiredType类型的Bean实例。
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name,Class<T> requiredType) throws BeansException;

    /**
     * 返回容器中属于requiredType类型的、唯一的bean实例。
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T>  T getBean(Class<T> requiredType) throws BeansException;

    /**
     * 判断容器中是否含有id为name的bean实例
     * @param name
     * @return
     */
    boolean containsBean(String name);
}
