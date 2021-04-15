package com.controller;

import com.validation.Validation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseMapper<E, R, R1> implements Validation<R> {

    List<R1> buildResponses(List<E> entities) {
        return entities.stream()
                .map(e -> mapToResponse(Optional.ofNullable(e)).get())
                .collect(Collectors.toList());
    }

    abstract Optional<R1> mapToResponse(Optional<E> e);

    abstract Optional<E> mapToEntity(Optional<R> request);

    Optional<E> buildEntity(Optional<R> request) {
        validate(request);
        return mapToEntity(request);
    }
}
