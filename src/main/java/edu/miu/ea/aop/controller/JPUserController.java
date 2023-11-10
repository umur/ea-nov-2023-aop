package edu.miu.ea.aop.controller;

import edu.miu.ea.aop.model.dto.JPAddressDTO;
import edu.miu.ea.aop.model.dto.JPReviewDTO;
import edu.miu.ea.aop.model.dto.JPUserDTO;
import edu.miu.ea.aop.service.JPAddressService;
import edu.miu.ea.aop.service.JPReviewService;
import edu.miu.ea.aop.service.JPUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class JPUserController {

    private final JPUserService service;
    private final JPReviewService reviewService;
    private final JPAddressService addressService;

    @PostMapping("/{userId}/address")
    JPAddressDTO addUserAddress(@PathVariable Long userId, @RequestBody JPAddressDTO addressDTO) throws Exception {
        return addressService.add(userId, addressDTO);
    }

    @PutMapping("/address/{addressId}")
    JPAddressDTO updateUserAddress(@PathVariable Long addressId, @RequestBody JPAddressDTO addressDTO) throws Exception {
        return addressService.update(addressId, addressDTO);
    }

    @PostMapping
    JPUserDTO add(@RequestBody JPUserDTO userDTO) {
        return service.add(userDTO);
    }

    @PutMapping("/{id}")
    JPUserDTO update(@PathVariable Long id, @RequestBody JPUserDTO userDTO) throws Exception {
        return service.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    boolean retire(@PathVariable Long id) throws Exception {
        return service.retire(id);
    }

    @GetMapping
    List<JPUserDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/search")
    JPUserDTO findById(@RequestParam Long id) throws Exception {
        return service.findById(id);
    }

    @GetMapping("/{userId}/reviews")
    List<JPReviewDTO> findUserReviews(@PathVariable Long userId) throws Exception {
        return reviewService.findAllByUserId(userId);
    }

    @GetMapping("/{userId}/address")
    JPAddressDTO findUserAddress(@PathVariable Long userId) throws Exception {
        return addressService.findUserAddress(userId);
    }

}
