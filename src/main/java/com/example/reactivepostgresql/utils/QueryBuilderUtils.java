package com.example.reactivepostgresql.utils;

import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

/**
 * 9:24 AM 15-Oct-22
 * Long Tran
 */
public class QueryBuilderUtils {

    public static void addDateFilter(Collection<Criteria> filterList, String fieldName, Date startDate, Date endDate) {
        if (startDate != null && endDate != null) {
            Criteria criteria = Criteria.where(fieldName).between(startDate,endDate);
            filterList.add(criteria);
        } else if (startDate != null) {
            Criteria criteria = Criteria.where(fieldName).greaterThan(startDate);
            filterList.add(criteria);
        } else if (endDate != null) {
            Criteria criteria = Criteria.where(fieldName).lessThan(endDate);
            filterList.add(criteria);
        }
    }
    public static void addSingleRegexSearch(Collection<Criteria> filterList, String fieldName, String value) {
        if (StringUtils.isNotEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).like(value);
            filterList.add(criteria);
        }
    }
    public static void addMultipleRegexSearch(Collection<Criteria> filterList,String value,String ...fieldNames) {
        if (Objects.nonNull(value) && Objects.nonNull(fieldNames)) {
          Arrays.stream(fieldNames).map(fieldName -> Criteria.where(fieldName).like(value)).forEach(filterList::add);
        }
    }

    public static void addSingleValueFilter(Collection<Criteria> filterList, String fieldName, Object value) {
        if (Objects.nonNull(value) && !value.toString().isEmpty()) {
            Criteria criteria = Criteria.where(fieldName).is(value);
            filterList.add(criteria);
        }
    }
    public static void addMultipleValuesFilter(Collection<Criteria> filterList, String fieldName, Collection<String> value) {
        if (!CollectionUtils.isEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).in(value);
            filterList.add(criteria);
        }
    }


    public static void addSingleValuesNinFilter(Collection<Criteria> filterList, String fieldName, Collection<String> value) {
        if (!CollectionUtils.isEmpty(value)) {
            Criteria criteria = Criteria.where(fieldName).notIn(value);
            filterList.add(criteria);
        }
    }
    public static void addSingleValueNeFilter(Collection<Criteria> filterList, String fieldName, String value) {
//        if (StringUtils.nonNullOrEmptyString(value)) {
            Criteria criteria = Criteria.where(fieldName).not(value);
            filterList.add(criteria);
//        }
    }

    public static void addPageable(Query query, @NotNull Pageable pageable, @NotNull Boolean isPageAble) {
        if(isPageAble){
            query.with(pageable);
        }else {
            pageable = Pageable.unpaged();
        }
    }
}
