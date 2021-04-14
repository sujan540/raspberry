package com.validation;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Validation<E> {

    default List<String> doValidate(Optional<E> e) {
        return Arrays.asList();
    }

    default void validate(Optional<E> e) {
        final List<String> issues = doValidate(e);
        if (e.isPresent() && !CollectionUtils.isEmpty(issues)) {
            throw new RuntimeException(issues.stream()
                    .collect(Collectors.joining(",")));
        }

    }
}
