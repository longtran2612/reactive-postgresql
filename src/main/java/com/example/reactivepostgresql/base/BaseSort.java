package com.example.reactivepostgresql.base;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 9:24 AM 15-Oct-22
 * Long Tran
 */
@Getter
@Setter
public class BaseSort {
    private String key;
    private Boolean asc = true;
}
