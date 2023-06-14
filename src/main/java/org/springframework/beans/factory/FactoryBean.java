package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author 储晓波
 * @date 2023/6/14 11:12
 * @desc
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    boolean isSingleton();
}
