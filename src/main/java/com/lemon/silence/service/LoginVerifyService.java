package com.lemon.silence.service;

import com.lemon.silence.utils.bo.GraphicBean;
import com.lemon.silence.utils.encryption.VerifyGraphicUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @author silence
 */
@Service
@Slf4j
public class LoginVerifyService {

    public GraphicBean getGraphicCode(){
        Map<String,Object> map = VerifyGraphicUtil.createImage();
        BufferedImage image = (BufferedImage) map.get("image");
        String uuid = map.get("uuid").toString();
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", byteOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = byteOut.toByteArray();
        GraphicBean graphicBean = new GraphicBean();
        graphicBean.setUuid(uuid);
        graphicBean.setGraphicCode(Base64.encodeBase64String(bytes));
        return graphicBean;
    }

    public boolean verityGraphicCode(GraphicBean graphicBean){
        return VerifyGraphicUtil.verityGraphicCode(graphicBean);
    }
}
