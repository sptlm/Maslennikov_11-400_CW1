package kfu.itis.maslennikov.hw6.service;

import kfu.itis.maslennikov.hw6.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
}
