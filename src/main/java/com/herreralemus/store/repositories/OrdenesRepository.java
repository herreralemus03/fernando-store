package com.herreralemus.store.repositories;

import com.herreralemus.store.models.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenesRepository extends JpaRepository<Orden, String> {
}
