package nuce.anh.service;

import nuce.anh.model.User;

public interface UserService {
    boolean findUserForLogin(User user);
}
