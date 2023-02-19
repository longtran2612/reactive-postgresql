package com.example.reactivepostgresql.service;

import com.example.reactivepostgresql.model.domain.SequenceValue;
import com.example.reactivepostgresql.repository.SequenceValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * 9:45 PM 18-Feb-23
 * Long Tran
 */
@Service
@RequiredArgsConstructor
public class SequenceValueService {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    private final SequenceValueRepository sequenceValueRepository;

    public Mono<String> getSequence(Class forClass) {
        String sequenceName = forClass.getName();
        Mono<SequenceValue> sequenceValueItem = sequenceValueRepository.findById(sequenceName).flatMap(sequenceValue -> {
           if(Objects.isNull(sequenceValue)) {
               sequenceValue = new SequenceValue();
               sequenceValue.setSeqId(1000);
               sequenceValue.setCreatedDate(LocalDate.now());
           }else{
               int sequenceId = sequenceValue.getSeqId() + 1;
                sequenceValue.setSeqId(sequenceId);
                sequenceValue.setUpdatedDate(LocalDate.now());
           }
            return sequenceValueRepository.save(sequenceValue);
        });
        return sequenceValueItem.map(sequenceValue -> {
            return String.valueOf(sequenceValue.getSeqId());
        });
    }
}
