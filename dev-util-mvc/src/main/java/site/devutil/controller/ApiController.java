package site.devutil.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.devutil.service.JsonService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {

    private final JsonService jsonService;

    @PostMapping(value = "/work/toString-json", consumes = "application/json")
    public String toStringJsonView(@RequestBody String toStr){
        log.info("INPUT {}", toStr);
        return jsonService.toStringToJson(toStr);
    }

}
