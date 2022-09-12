package com.example.reportbuilder.repository;

import com.example.reportbuilder.entity.TransactionReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionReportRepository extends CrudRepository<TransactionReport, Long> {

    List<TransactionReport> findAllByWithdrawUsername(String withdrawUsername);

    List<TransactionReport> findAllByDepositUsername(String depositUsername);
}
