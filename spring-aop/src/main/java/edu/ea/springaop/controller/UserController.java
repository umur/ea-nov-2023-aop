package edu.ea.springaop.controller;

 
import edu.ea.springaop.dto.FullAddressDto;
import edu.ea.springaop.dto.FullReviewDto;
import edu.ea.springaop.dto.FullUserDto;
import edu.ea.springaop.service.AddressService;
import edu.ea.springaop.service.ReviewService;
import edu.ea.springaop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ReviewService reviewService;

    private final AddressService addressService;
    @GetMapping
    List<FullUserDto> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/search")
    FullUserDto findById(@RequestParam Integer id) throws Exception {
        return userService.findById(id);
    }

    @GetMapping("/{userId}/reviews")
    List<FullReviewDto> findUserReviews(@PathVariable  Integer userId) throws Exception {
        return reviewService.findAllByUserId(userId);
    }
    @GetMapping("/{userId}/address")
    FullAddressDto findUserAddress(@PathVariable  Integer userId) throws Exception {
        return addressService.findUserAddress(userId);
    }

    @PostMapping("/{userId}/address")
    FullAddressDto addUserAddress(@PathVariable  Integer userId,@RequestBody  FullAddressDto fullAddressDto) throws Exception {
        return addressService.add(userId,fullAddressDto);
    }

    @PutMapping("/address/{addressId}")
    FullAddressDto updateUserAddress(@PathVariable  Integer addressId,@RequestBody  FullAddressDto fullAddressDto) throws Exception {
        return addressService.update(addressId,fullAddressDto);
    }

    @PostMapping
    FullUserDto add ( @RequestBody  FullUserDto fullUserDto)   {
        return userService.add(fullUserDto);
    }


    @PutMapping("/{id}")
    FullUserDto update (@PathVariable Integer id,@RequestBody  FullUserDto fullUserDto) throws Exception {
        return userService.update(id,fullUserDto);
    }

    @DeleteMapping("/{id}")
    boolean delete (@PathVariable Integer id ) throws Exception {
        return userService.delete(id);
    }


}
