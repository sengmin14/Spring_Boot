package com.study.study.item.service;

import com.study.study.blog.domain.Article;
import com.study.study.blog.dto.UpdateArticleRequest;
import com.study.study.item.domain.Item;
import com.study.study.item.dto.AddItemRequest;
import com.study.study.item.dto.UpdateItemRequest;
import com.study.study.item.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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
//        System.out.println(itemRepository.findAll());
        return itemRepository.findAll();
    }

    public Item findById(long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found : " + id));
    }

    public void delete(long id){
        itemRepository.deleteById(id);
    }

    @Transactional
    public Item update(long id, UpdateItemRequest request) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found : " + id));

        item.update(request.getItemName(), request.getPrice(), request.getQuantity());

        return item;
    }

}
