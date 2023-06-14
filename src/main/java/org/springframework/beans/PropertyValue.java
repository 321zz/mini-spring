package org.springframework.beans;

/**
 * @author 储晓波
 * @date 2023/6/14 13:46
 * @desc
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
