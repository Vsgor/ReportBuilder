package com.example.download_scheduler.kafka;

import com.example.download_scheduler.service.DownloadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@Component
@RequiredArgsConstructor
public class DownloadRequestConsumer {

    private final DownloadService downloadService;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void listen(String message) {
        log.info("got the message {}", message);
        if (isNotBlank(message)) {
            URL someUri;

            try {
                someUri = new URL(message);
                downloadService.downloadFromUri(someUri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
