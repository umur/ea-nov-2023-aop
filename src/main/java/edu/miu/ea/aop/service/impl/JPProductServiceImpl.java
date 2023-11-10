package edu.miu.ea.aop.service.impl;

import edu.miu.ea.aop.model.domain.JPProduct;
import edu.miu.ea.aop.model.dto.JPProductDTO;

import edu.miu.ea.aop.repository.JPProductRepository;
import edu.miu.ea.aop.service.JPProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JPProductServiceImpl implements JPProductService {

    private final ModelMapper modelMapper;

    private final JPProductRepository repository;

    @Override
    @Transactional
    public JPProductDTO add(JPProductDTO productDTO) {

        return modelMapper.map(repository.save(modelMapper.map(productDTO, JPProduct.class)), JPProductDTO.class);

    }

    @Override
    @Transactional
    public JPProductDTO update(Long id, JPProductDTO productDTO) throws Exception {

        Optional<JPProduct> optionalProduct = repository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new Exception("JPProduct doesn't exist");
        }

        productDTO.setId(id);

        return modelMapper.map(repository.save(modelMapper.map(productDTO, JPProduct.class)), JPProductDTO.class);

    }

    @Override
    public List<JPProductDTO> findAll() {

        return repository.findAll().stream().map(c -> modelMapper.map(c, JPProductDTO.class)).collect(Collectors.toList());

    }

    @Override
    public JPProductDTO findById(Long id) throws Exception {

        Optional<JPProduct> optionalProduct = repository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new Exception("JPProduct doesn't exist");
        }

        JPProduct product = optionalProduct.get();

        return modelMapper.map(product, JPProductDTO.class);

    }

    @Override
    @Transactional
    public boolean retire(Long id) throws Exception {

        Optional<JPProduct> optionalProduct = repository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new Exception("JPProduct doesn't exist");
        }

        JPProduct product = optionalProduct.get();
        product.setRetired(true);
        repository.save(product);
        return true;

    }

}
