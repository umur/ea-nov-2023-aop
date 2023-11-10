package edu.miu.ea.aop.service.impl;

import edu.miu.ea.aop.model.domain.JPUser;
import edu.miu.ea.aop.model.dto.JPUserDTO;
import edu.miu.ea.aop.repository.JPUserRepository;
import edu.miu.ea.aop.service.JPUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JPUserServiceImpl implements JPUserService {

    private final ModelMapper modelMapper;

    private final JPUserRepository repository;

    @Override
    @Transactional
    public JPUserDTO add(JPUserDTO userDto) {

        return modelMapper.map(repository.save(modelMapper.map(userDto, JPUser.class)), JPUserDTO.class);

    }

    @Override
    @Transactional
    public JPUserDTO update(Long id, JPUserDTO userDto) throws Exception {

        Optional<JPUser> oldUser = repository.findById(id);

        if (!oldUser.isPresent()) {
            throw new Exception("JPUser doesn't exist");
        }

        JPUser user = modelMapper.map(userDto, JPUser.class);

        user.setId(id);

        return modelMapper.map(repository.save(user), JPUserDTO.class);

    }

    @Override
    public List<JPUserDTO> findAll() {

        return repository.findAll().stream().map(u -> modelMapper.map(u, JPUserDTO.class)).collect(Collectors.toList());

    }

    @Override
    public JPUserDTO findById(Long id) throws Exception {

        Optional<JPUser> user = repository.findById(id);

        if (!user.isPresent()) {
            throw new Exception("JPUser doesn't exist");
        }

        return modelMapper.map(user.get(), JPUserDTO.class);

    }

    @Override
    @Transactional
    public boolean retire(Long id) throws Exception {

        Optional<JPUser> oldUser = repository.findById(id);

        if (!oldUser.isPresent()) {
            throw new Exception("JPUser doesn't exist");
        }

        JPUser user = oldUser.get();
        user.setRetired(true);
        repository.save(user);

        return true;

    }

}
