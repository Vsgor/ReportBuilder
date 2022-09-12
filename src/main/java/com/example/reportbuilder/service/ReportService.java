package com.example.reportbuilder.service;

import com.example.reportbuilder.dataobject.TransactionReportDto;
import com.example.reportbuilder.entity.TransactionReport;
import com.example.reportbuilder.mapper.TransactionReportMapper;
import com.example.reportbuilder.repository.TransactionReportRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportService {

    private final TransactionReportMapper transactionReportMapper;
    private final TransactionReportRepository transactionReportRepository;

    // todo: сохранение в редис бд
    public void saveTransactionReport(TransactionReportDto reportDto) {
        TransactionReport transactionReport = transactionReportMapper.mapFromDto(reportDto);
        transactionReportRepository.save(transactionReport);
    }


//    Todo: добавить шедулер для переноса логов из редис в постгрес
}
