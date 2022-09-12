package com.example.reportbuilder.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class TransactionReport {

    @Id
    private Long id;

    private String withdrawUsername;
    private String depositUsername;
    private Long withdrawState;
    private Long transferSum;
}
