package com.lemon.silence.utils.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * XML和javabean工具
 *
 * @author silence
 */
public class XmlBeanUtils {

    /**
     * 将javabean转换成xml字符串
     */
    private static String bean2Xml(Object obj) throws Exception {
        //获取上下文
        final JAXBContext context = JAXBContext.newInstance(obj.getClass());
        //创建一个将bean序列化成xml的对象
        Marshaller marshaller = context.createMarshaller();
        //格式化输出
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //设置编码
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter writer = new StringWriter();
        //序列化
        marshaller.marshal(obj, writer);
        return writer.toString();
    }

    /**
     * 将xml字符串转换成javabean
     */
    private static <T> T xml2Bean(String xml, Class<T> clazz) throws Exception {
        //获取上下文
        final JAXBContext context = JAXBContext.newInstance(clazz);
        //创建一个xml转换成bean的对象
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //反序列化
        return clazz.cast(unmarshaller.unmarshal(new StringReader(xml)));
    }
}
