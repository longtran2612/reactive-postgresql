package com.example.reactivepostgresql.base;

import com.example.reactivepostgresql.service.SequenceValueService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * 9:42 PM 18-Feb-23
 * Long Tran
 */
@Component
public class BaseService extends BaseObjectLoggable{
    @Autowired
    protected R2dbcEntityTemplate r2dbcEntityTemplate;

    @Autowired
    protected SequenceValueService sequenceValueService;


    @Autowired
    protected Validator validator;

    protected void validate(Object object) {
       var violations = validator.validate(object);
       logger.info("Violations: {}", violations);
       if (!violations.isEmpty()) {
           throw new RuntimeException(violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", ")));
       }

    }
}
