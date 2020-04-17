package com.ljx.dubbo.restful.util;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import java.io.File;
import java.util.List;
import java.util.Objects;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * @author jiaxiong
 * @date 2020/4/14 5:01 下午
 */
public class JavaEmailHandler {

    private static final Logger logger = LoggerFactory.getLogger(JavaEmailHandler.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String sendMailAddress;

    public void sendTextMail(List<String> toList, String subject, String text) {
        logger.info("发送邮件, userList:{}, subject:{}, text:{}", toList, subject, text);
        toList.parallelStream().forEach(user -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sendMailAddress);
            message.setTo(user);
            message.setSubject(subject);
            message.setText(text);
            try {
                javaMailSender.send(message);
                logger.info("发送邮件, sendSimpleMessage | 成功");
            } catch (Exception e) {
                logger.info("发送邮件, sendSimpleMessage | 失败", e);
            }
        });
    }

    public void sendHtmlMail(List<String> toList, String subject, String content) {
        logger.info("发送邮件, userList:{}, subject:{}, text:{}", toList, subject, content);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sendMailAddress);
            helper.setSubject(subject);
            String sb = "<h1>尊敬的客户您好！</h1>"
                    + "<p>欢迎您的访问</p>"
                    + content;
            helper.setText(sb, true);

            toList.parallelStream().forEach(user -> {
                try {
                    helper.setTo(user);
                    javaMailSender.send(message);
                    logger.info("发送邮件, sendSimpleMessage | 成功");
                } catch (Exception e) {
                    logger.info("发送邮件, sendSimpleMessage | 失败", e);
                }
            });
        } catch (MessagingException e) {
            logger.warn("发送邮件失败");
        }
    }

    public void sendAttachMail(List<String> toList, String subject, String text,
            List<File> fileList) {
        logger.info("发送邮件, sendAttachMessage | userList:{}, subject:{}, text:{}, fileNum:{}",
                toList, subject, text, Objects
                        .isNull(fileList) ? 0 : fileList.size());
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sendMailAddress);
            helper.setSubject(subject);
            helper.setText(text);
            if (CollectionUtils.isNotEmpty(fileList)) {
                fileList.forEach(file -> {
                    try {
                        helper.addAttachment(file.getName(), file);
                    } catch (MessagingException e) {
                        logger.error("发送邮件,添加附件失败, title:{}, name:{}", subject, file.getName(), e);
                    }
                });
            }
            toList.parallelStream().forEach(user -> {
                try {
                    helper.setTo(user);
                    javaMailSender.send(message);
                    logger.info("发送邮件, sendSimpleMessage | 成功");
                } catch (Exception e) {
                    logger.info("发送邮件, sendSimpleMessage | 失败", e);
                }
            });
        } catch (MessagingException e) {
            logger.error("发送邮件,失败, title:{}, content:{}", subject, text, e);
        }
    }
}
