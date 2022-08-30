package com.example.download_scheduler.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
@Service
public class DownloadService {

    private static final String HOME_LOCATION = System.getProperty("user.home");

    @SneakyThrows
    public void downloadFromUri(URL url) {
        Path filePath = generateFileName();

        try (ReadableByteChannel readChannel = Channels.newChannel(url.openStream());
             FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            fileChannel.transferFrom(readChannel, 0, Long.MAX_VALUE);

            stopWatch.stop();
            log.info("{} has been downloaded for {} ms", filePath, stopWatch.getLastTaskTimeMillis());
        }
    }

    @SuppressWarnings("WrapperTypeMayBePrimitive")
    @SneakyThrows
    private Path generateFileName() {
        Path downloadDirectory = Files.createDirectories(Path.of(HOME_LOCATION, "Downloads", "From Java"));
        Double randomDouble = Math.random() * 10000000;

        return downloadDirectory.resolve(randomDouble.longValue() + ".html");
    }
}
