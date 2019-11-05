package cn.com.hatech.app.demo.manager.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.util.Map;

@FeignClient(value = "hatech-app-business")
public interface AppBusinessFeignService {

    @GetMapping("/hi")
    Map<String, Object> hi();

}
