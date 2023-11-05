package edu.ea.springaop.service.impl;

import edu.ea.springaop.dto.FullUserDto;
import edu.ea.springaop.model.User;
import edu.ea.springaop.repository.UserRepo;
import edu.ea.springaop.service.UserService;
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
public class UserServiceImpl  implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;



    @Override

    public List<FullUserDto> findAll() {
        return userRepo.findAll().stream().map(u ->  modelMapper.map(u,FullUserDto.class)).collect(Collectors.toList());
    }

    @Override
    public FullUserDto findById(Integer id) throws Exception {
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent())
            throw  new Exception("User not found");
        return  modelMapper.map(user.get(),FullUserDto.class);
    }

    @Override
    @Transactional
    public FullUserDto add(FullUserDto userDto) {
      return modelMapper.map(  userRepo.save(modelMapper.map(userDto,User.class)),FullUserDto.class);

    }

    @Override
    @Transactional
    public FullUserDto update(Integer id, FullUserDto userDto) throws Exception {
        Optional<User> oldUser = userRepo.findById(id);
        if(!oldUser.isPresent())
            throw  new Exception("User not found");
        User user = modelMapper.map(userDto,User.class);
        user.setId(id);
        return   modelMapper.map(userRepo.save(user),FullUserDto.class);
    }

    @Override
    @Transactional
    public boolean delete(Integer userId) throws Exception {
        Optional<User> oldUser = userRepo.findById(userId);
        if(!oldUser.isPresent())
            throw  new Exception("User not found");

        User user = oldUser.get();
        user.setDeleted(true);
        userRepo.save(user);
     return true;

    }

}
