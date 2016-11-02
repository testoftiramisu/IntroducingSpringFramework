package io.testoftiramisu.java.utils;

import com.thoughtworks.xstream.XStream;

public class XmlUtils {

    public static <T> String toXML(T object) {
        XStream xstream = new XStream();
        xstream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xstream.toXML(object);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T fromXML(String xml, Class<T> _class) {
        XStream xstream = new XStream();
        xstream.alias(_class.getSimpleName().toLowerCase(), _class);
        return (T) xstream.fromXML(xml);
    }
}
