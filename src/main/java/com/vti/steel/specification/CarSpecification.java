package com.vti.steel.specification;

import com.vti.steel.entity.Car;
import com.vti.steel.form.CarFilterForm;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarSpecification {
    public static Specification<Car> buildSpec(CarFilterForm form) {
        return form == null ? null : new Specification<Car>() {
            @Override
            public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                String search = form.getSearch();
                if (StringUtils.hasText(search)) {
                    String pattern = "%" + search.trim() + "%";
                    Predicate hasCustomerNameLike = criteriaBuilder.like(root.get("customer_name"),pattern);
                    predicates.add(hasCustomerNameLike);
                }
                var minCreatedDate = form.getMinCreatedDate();
                if (minCreatedDate != null) {
                    var minCreatedAt = LocalDateTime.of(minCreatedDate, LocalTime.MIN);
                    var predicate = criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class),
                            minCreatedAt);
                    predicates.add(predicate);
                }
                var maxCreatedDate = form.getMaxCreatedDate();
                if (maxCreatedDate != null) {
                    var maxCreatedAt = LocalDateTime.of(maxCreatedDate, LocalTime.MAX);
                    var predicate = criteriaBuilder.lessThanOrEqualTo(root.get("createdAt").as(LocalDateTime.class),
                            maxCreatedAt);
                    predicates.add(predicate);
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}


