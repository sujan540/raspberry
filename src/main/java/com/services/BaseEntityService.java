package com.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseEntityService<E> implements EntityService<E> {

    @Override
    public Optional<E> saveOrUpdate(Optional<E> entity) {
        final Optional<E> preUpdate = preSaveEntity(entity);
        validate(preUpdate);
        if (preUpdate.isPresent()) {
            return Optional.ofNullable(getEntityRepository().save(preUpdate.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<E> saveOrUpdateAll(List<E> entities) {
        return entities.stream()
                .map(entity -> saveOrUpdate(Optional.ofNullable(entity)).get())
                .collect(Collectors.toList());
    }

    @Override
    public void delete(E entity) {
        getEntityRepository().delete(entity);
    }

    protected Optional<E> preSaveEntity(Optional<E> entity) {
        return entity;
    }

    ;

    protected abstract JpaRepository<E, Long> getEntityRepository();
}
