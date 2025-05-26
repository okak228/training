package com.example.app.util;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SpecificationHelper {
    private final static String LIKE = "%";

    public static String toLike(String value) {
        return LIKE + value.toLowerCase() + LIKE;
    }

    public static Predicate toLikePredicate(CriteriaBuilder criteriaBuilder, Expression<String> expression, String value) {
        return criteriaBuilder.like(criteriaBuilder.lower(expression), toLike(value));
    }
}
