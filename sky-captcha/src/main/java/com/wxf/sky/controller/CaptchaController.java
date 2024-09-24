package com.wxf.sky.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.*;
import java.io.IOException;

/**
 * @author Wxf
 * @since 2024-09-24 16:11:12
 **/
@RestController
@RequestMapping(value = "/captcha")
public class CaptchaController {

    @Autowired
    private Producer kaptchaProducer;

    @GetMapping("/code/kaptcha")
    public void getCodeByKaptcha(HttpServletResponse response) {
        // 生成文字验证码
        String text = kaptchaProducer.createText();
        System.out.println("文字验证码：" + text);
        // 生成图片验证码
        BufferedImage image = kaptchaProducer.createImage(text);

        // 设置响应头，防止缓存
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
