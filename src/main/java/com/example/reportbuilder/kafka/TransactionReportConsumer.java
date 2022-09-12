package com.example.reportbuilder.kafka;

import com.example.reportbuilder.dataobject.TransactionReportDto;
import com.example.reportbuilder.service.ReportService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionReportConsumer {

    private final ReportService reportService;
    private final ObjectMapper jsonMapper;

    @SneakyThrows
    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void listen(String reportMessage) {
        reportService.saveTransactionReport(jsonMapper.readValue(reportMessage, TransactionReportDto.class));
    }

}
