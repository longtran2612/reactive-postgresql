package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.model.domain.SequenceValue;
import com.example.reactivepostgresql.repository.SequenceValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

/**
 * 9:45 PM 18-Feb-23
 * Long Tran
 */
@Service
@RequiredArgsConstructor
public class SequenceValueService {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    private final SequenceValueRepository sequenceValueRepository;

    public  String getSequence(Class forClass) {
        String sequenceName = forClass.getName();
        SequenceValue sequenceValueItem = sequenceValueRepository.findById(sequenceName).block();
        if (null == sequenceValueItem) {
            sequenceValueItem = new SequenceValue();
            sequenceValueItem.setId(sequenceName);
            sequenceValueItem.setSeqId(1000);
            sequenceValueItem.setCreatedDate(LocalDate.now());
            sequenceValueRepository.save(sequenceValueItem);
            return "1000";
        }
        int sequenceId = sequenceValueItem.getSeqId() + 1;
        sequenceValueItem.setSeqId(sequenceId);
        sequenceValueItem.setUpdatedDate(LocalDate.now());
        sequenceValueRepository.save(sequenceValueItem);
        return String.valueOf(sequenceId);
    }
}
