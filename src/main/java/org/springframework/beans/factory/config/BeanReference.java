package org.springframework.beans.factory.config;

/**
 * @author 储晓波
 * @date 2023/6/14 14:33
 * @desc 一个bean对另一个bean的引用
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
