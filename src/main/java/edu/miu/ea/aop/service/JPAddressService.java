package edu.miu.ea.aop.service;

import edu.miu.ea.aop.model.dto.JPAddressDTO;

public interface JPAddressService {

    JPAddressDTO add(Long userId, JPAddressDTO addressDto) throws Exception;

    JPAddressDTO update(Long addressId, JPAddressDTO addressDto) throws Exception;

    JPAddressDTO findUserAddress(Long userId) throws Exception;

    boolean retire(Long id) throws Exception;

}
