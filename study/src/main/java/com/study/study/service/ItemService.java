package com.study.study.service;

import com.study.study.domain.Item;
import com.study.study.dto.AddItemRequest;
import com.study.study.dto.ItemResponse;
import com.study.study.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Item save(AddItemRequest request) {
        return itemRepository.save(request.toEntity());
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

}
