package xyz.yuanwl.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class AnotherBean {
    @Value("其他Bean的配置")
    private String str;
}