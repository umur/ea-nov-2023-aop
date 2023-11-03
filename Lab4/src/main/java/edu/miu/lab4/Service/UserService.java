package edu.miu.lab4.Service;

import edu.miu.lab4.Model.User;

public interface UserService {
    User findById(int id);
    User saveUser(User user);
    User updateUser(int id,User user);
    void deleteUser(int id);

}
