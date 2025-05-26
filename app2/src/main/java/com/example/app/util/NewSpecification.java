package com.example.app.util;

import com.example.app.entity.NewEntity;
import com.example.app.entity.User;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import static com.example.app.util.SpecificationHelper.toLikePredicate;

@UtilityClass
public class NewSpecification {
    public static Specification<NewEntity> newEntitySpecification(String name) {
        return (root, query, criteriaBuilder) -> {
            if (StringUtils.isNotBlank(name)) {
                return toLikePredicate(criteriaBuilder, root.get(User.Fields.name), name);
            } else {
                return null;
            }
        };
    }
}
