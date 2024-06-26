package com.study.study.item.controller;

import com.study.study.blog.domain.Article;
import com.study.study.blog.dto.UpdateArticleRequest;
import com.study.study.item.domain.Item;
import com.study.study.item.dto.AddItemRequest;
import com.study.study.item.dto.ItemResponse;
import com.study.study.item.dto.UpdateItemRequest;
import com.study.study.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class ItemApiController {
    private final ItemService itemService;

    @Operation(summary = "아이템 등록 요청", description = "아이템 등록 했을 때 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "아이템 등록 성공")
    })
    @PostMapping("/api/items")
    public ResponseEntity<Item> addArticle(@RequestBody AddItemRequest request) {
        Item saveItem = itemService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveItem);

    }

    @Operation(summary = "아이템 목록 조회 요청", description = "아이템 목록 조회 했을 때 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "아이템 목록 조회 성공")
    })
    @GetMapping("/api/items")
    public ResponseEntity<List<ItemResponse>> findAllItems() {
        List<ItemResponse> items = itemService.findAll()
                .stream()
                .map(ItemResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(items);
    }

    @Operation(summary = "아이템 조회 요청", description = "아이템 조회 했을 때 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "아이템 조회 성공")
    })
    @GetMapping("/api/items/{id}")
    @CrossOrigin
    public ResponseEntity<ItemResponse> findItem(@PathVariable long id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok()
                .body(new ItemResponse(item));
    }

    @Operation(summary = "아이템 삭제 요청", description = "아이템 삭제 했을 때 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "아이템 삭제 성공")
    })
    @DeleteMapping("/api/items/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        itemService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @Operation(summary = "아이템 수정 요청", description = "아이템 수정 했을 때 동작을 수행하는 API입니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "아이템 수정 성공")
    })
    @PutMapping("/api/items/{id}")
    public ResponseEntity<Item> updateArticle(@PathVariable long id, @RequestBody UpdateItemRequest request) {
        Item updateItem = itemService.update(id, request);

        return ResponseEntity.ok()
                .body(updateItem);
    }
}
