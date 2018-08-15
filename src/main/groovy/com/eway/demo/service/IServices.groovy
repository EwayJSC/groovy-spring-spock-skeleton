package com.eway.demo.service

interface IServices<M, E, ID> {
    List<E> save(List<E> list)

    List<E> getAll()

    Optional<E> save(E entity)

    M getExistEntity(E entity)

    Optional<E> get(ID id)
}