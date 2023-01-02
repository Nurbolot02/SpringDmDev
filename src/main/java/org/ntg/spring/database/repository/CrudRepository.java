package org.ntg.spring.database.repository;

import java.util.Optional;

public interface CrudRepository<K, E> {
    Optional<E> findById(K id);
    boolean deleteById(K id);
}
