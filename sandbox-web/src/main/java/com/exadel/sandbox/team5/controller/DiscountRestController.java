package com.exadel.sandbox.team5.controller;

import com.exadel.sandbox.team5.dto.DiscountDto;
import com.exadel.sandbox.team5.entity.Review;
import com.exadel.sandbox.team5.service.DiscountService;
import com.exadel.sandbox.team5.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountRestController {

    private final DiscountService service;
    private final ReviewService reviewService;
    private final DiscountService discountService;

    @GetMapping("/{id}")
    public DiscountDto getDiscount(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<DiscountDto> getAll() {
        return service.getAll();
    }

    @PostMapping
    public DiscountDto save(@RequestBody DiscountDto entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public DiscountDto update(@PathVariable Long id, @RequestBody DiscountDto entity) {
        entity.setId(id);
        return service.update(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{discountId}/reviews")
    public List<Review> getReviewsByDiscount(@PathVariable Long discountId) {
        return reviewService.getReviewsByDiscount(discountId);
    }

    @ApiOperation("Generating QR code with text \"Exadel employee. Special discount\"")
    @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> generateQRCode() {
        return ResponseEntity.ok(discountService.generateQRCode());
    }
}

