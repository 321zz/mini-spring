package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author 储晓波
 * @date 2023/6/14 14:30
 * @desc
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
