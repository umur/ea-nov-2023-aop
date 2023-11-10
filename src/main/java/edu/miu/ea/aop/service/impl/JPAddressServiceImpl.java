package edu.miu.ea.aop.service.impl;

import edu.miu.ea.aop.model.domain.JPAddress;
import edu.miu.ea.aop.model.dto.JPAddressDTO;

import edu.miu.ea.aop.model.dto.JPUserDTO;
import edu.miu.ea.aop.repository.JPAddressRepository;
import edu.miu.ea.aop.service.JPAddressService;
import edu.miu.ea.aop.service.JPUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JPAddressServiceImpl implements JPAddressService {

    private final ModelMapper modelMapper;

    private final JPAddressRepository repository;

    private final JPUserService userService;

    @Override
    @Transactional
    public JPAddressDTO add(Long userId, JPAddressDTO addressDto) throws Exception {

        JPUserDTO userDTO = userService.findById(userId);

        if (userDTO.getAddress() != null) {
            throw new Exception("JPUser - address available before");
        }

        JPAddress saveAddress = repository.save(modelMapper.map(addressDto, JPAddress.class));
        userDTO.setAddress(modelMapper.map(saveAddress, JPAddressDTO.class));
        JPUserDTO updateUser = userService.update(userDTO.getId(), userDTO);

        return updateUser.getAddress();

    }

    @Override
    @Transactional
    public JPAddressDTO update(Long addressId, JPAddressDTO addressDto) throws Exception {

        Optional<JPAddress> optAddress = repository.findById(addressId);

        if (!optAddress.isPresent()) {
            throw new Exception("JPAddress doesn't exist");
        }

        JPAddress address = modelMapper.map(addressDto, JPAddress.class);
        address.setId(addressId);
        JPAddress savedAddress = repository.save(address);

        return modelMapper.map(savedAddress, JPAddressDTO.class);

    }

    @Override
    public JPAddressDTO findUserAddress(Long userId) throws Exception {

        JPUserDTO userDTO = userService.findById(userId);

        return userDTO.getAddress();

    }

    @Override
    public boolean retire(Long id) throws Exception {
        return false;
    }

}
