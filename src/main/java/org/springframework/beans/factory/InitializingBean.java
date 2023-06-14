package org.springframework.beans.factory;

/**
 * @author 储晓波
 * @date 2023/6/14 14:22
 * @desc
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
