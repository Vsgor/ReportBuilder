package com.example.reportbuilder.mapper;

import com.example.reportbuilder.dataobject.TransactionReportDto;
import com.example.reportbuilder.entity.TransactionReport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionReportMapper {

    TransactionReport mapFromDto(TransactionReportDto transactionReportDto);
}
