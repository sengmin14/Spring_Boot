package com.study.study.controller;

import com.study.study.domain.Article;
import com.study.study.domain.Item;
import com.study.study.dto.AddArticleRequest;
import com.study.study.dto.AddItemRequest;
import com.study.study.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
