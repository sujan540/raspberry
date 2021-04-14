package com.services;

import com.validation.Validation;

import java.util.List;
import java.util.Optional;

public interface EntityService<E> extends Validation<E> {

    Optional<E> saveOrUpdate(Optional<E> entity);

    List<E> saveOrUpdateAll(List<E> entities);

    void delete(E entity);
}
