package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author 储晓波
 * @date 2023/6/14 10:06
 * @desc
 */
public interface ObjectFactory<T> {

    T getObject() throws BeansException;
}
