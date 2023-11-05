package com.miu.lab4aop.controller;

import com.miu.lab4aop.dto.AddressDto;
import com.miu.lab4aop.exceptions.ResourceNotFoundException;
import com.miu.lab4aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/addresses")
@RestController
@Slf4j
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated AddressDto addressDto) {
        addressService.save(addressDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> findById(@PathVariable("id") Integer id) {
        AddressDto address = addressService.findById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional.ofNullable(addressService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<AddressDto>> pageQuery() {
        List<AddressDto> addressPage = addressService.findByCondition();
        return ResponseEntity.ok(addressPage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> update(@RequestBody @Validated AddressDto addressDto, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(addressService.update(addressDto, id));
    }
}
