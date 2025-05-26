package com.example.app.mapper;

import com.example.app.controller.newentity.rq.CreateNewEntityRq;
import com.example.app.controller.newentity.rq.UpdateNewEntityRq;
import com.example.app.controller.newentity.rs.NewEntityRs;
import com.example.app.dto.response.PageRs;
import com.example.app.entity.NewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public abstract class NewEntityMapper {
    @Mapping(target = "userId", source = "entity.user.id")
    public abstract NewEntityRs toRs(NewEntity entity);

    public abstract NewEntity toEntity(CreateNewEntityRq rq);

    public PageRs<NewEntityRs> toPageResponse(Page<NewEntity> entities) {
        return new PageRs<>(entities.map(this::toRs));
    }

    public abstract void update(UpdateNewEntityRq rq, @MappingTarget NewEntity entity);
}
