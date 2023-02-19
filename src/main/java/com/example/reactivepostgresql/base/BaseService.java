package com.example.reactivepostgresql.base;

import com.example.reactivepostgresql.service.SequenceValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;

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
}
