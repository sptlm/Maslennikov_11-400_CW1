package kfu.itis.maslennikov.service;

import kfu.itis.maslennikov.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
}
