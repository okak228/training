package com.example.app.dto.response;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

public class PageRs <T> {
    private final Page<?> page;
    @Getter
    private final List<T> items;

    public PageRs(Page<T> page) {
        this.page = page;
        this.items = page.getContent();
    }

    public int getTotal() {
        return page.getTotalPages();
    }
}
