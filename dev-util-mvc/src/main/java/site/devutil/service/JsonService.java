package site.devutil.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.devutil.worker.JsonWorker;

@Service
@RequiredArgsConstructor
public class JsonService {
    private final JsonWorker jsonWorker;

    public String toStringToJson(String str) {
        return jsonWorker.toStringToJson(str);
    }

}
