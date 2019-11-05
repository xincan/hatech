package cn.com.hatech.app.business.manager.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "hatech-app-demo")
public interface AppDemoFeignService {

    @GetMapping("/hi")
    Map<String, Object> hi();

}
