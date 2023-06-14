package org.springframework.core.convert;

/**
 * @author 储晓波
 * @date 2023/6/14 11:04
 * @desc 类型转换抽象接口
 */
public interface ConversionService {
    boolean canConvert(Class<?> sourceType,Class<?> targetType);

    <T> T convert(Object source, Class<T> targetType);
}
