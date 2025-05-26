package com.example.app.service;

import com.example.app.controller.newentity.rq.CreateNewEntityRq;
import com.example.app.controller.newentity.rq.UpdateNewEntityRq;
import com.example.app.controller.newentity.rs.NewEntityRs;
import com.example.app.dto.response.PageRs;
import com.example.app.entity.NewEntity;
import com.example.app.entity.User;
import com.example.app.exception.EntityNotFoundException;
import com.example.app.mapper.NewEntityMapper;
import com.example.app.repository.NewEntityRepository;
import com.example.app.util.NewSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewEntityService {
    @Lazy
    @Autowired
    private final UserService userService;
    private final NewEntityRepository newEntityRepository;
    private final NewEntityMapper newEntityMapper;

    @Transactional(readOnly = true)
    public NewEntity findById(UUID id) {
        return newEntityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    @Transactional(readOnly = true)
    public NewEntityRs getById(UUID id) {
        return newEntityMapper.toRs(findById(id));
    }

    @Transactional(readOnly = true)
    public PageRs<NewEntityRs> getPage(Pageable pageRequest, String name) {
        return newEntityMapper.toPageResponse(newEntityRepository.findAll(NewSpecification.newEntitySpecification(name), pageRequest));
    }

    @Transactional
    public NewEntityRs create(CreateNewEntityRq rq) {
        NewEntity entity = newEntityMapper.toEntity(rq);
        entity.setUser(userService.findById(rq.getUserId()));
        return newEntityMapper.toRs(newEntityRepository.save(entity));
    }

    @Transactional
    public NewEntityRs update(UpdateNewEntityRq rq) {
        NewEntity entity = findById(rq.getId());
        newEntityMapper.update(rq, entity);
        entity.setUser(userService.findById(rq.getUserId()));
        return newEntityMapper.toRs(entity);
    }

    @Transactional
    public void delete(UUID id) {
        NewEntity entity = findById(id);
        newEntityRepository.delete(entity);
    }
}
