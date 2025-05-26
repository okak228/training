package com.example.app.repository;

import com.example.app.entity.NewEntity;
import com.example.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface NewEntityRepository extends JpaRepository<NewEntity, UUID>, JpaSpecificationExecutor<NewEntity> {
}
