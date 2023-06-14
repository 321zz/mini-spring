package org.springframework.beans;

/**
 * @author 储晓波
 * @date 2023/6/14 9:40
 * @desc
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
