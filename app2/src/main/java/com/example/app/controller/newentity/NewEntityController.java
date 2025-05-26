package com.example.app.controller.newentity;

import com.example.app.controller.newentity.rq.CreateNewEntityRq;
import com.example.app.controller.newentity.rq.UpdateNewEntityRq;
import com.example.app.controller.newentity.rs.NewEntityRs;
import com.example.app.dto.response.PageRs;
import com.example.app.service.NewEntityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/entities")
@RequiredArgsConstructor
public class NewEntityController {
    private final NewEntityService newEntityService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public PageRs<NewEntityRs> getPage(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "name", required = false) String name
    ) {
        if (null == page) page = 1;
        if (null == size) size = 5;
        if (StringUtils.isEmpty(sortBy)) sortBy = "name";
        return newEntityService.getPage(PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc(sortBy))), name);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public NewEntityRs getById(@PathVariable("id") @NotNull UUID id) {
        return newEntityService.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public NewEntityRs create(@RequestBody @Valid CreateNewEntityRq rq) {
        return newEntityService.create(rq);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public NewEntityRs update(@RequestBody @Valid UpdateNewEntityRq rq) {
        return newEntityService.update(rq);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public void delete(@PathVariable("id") @NotNull UUID id) {
        newEntityService.delete(id);
    }
}