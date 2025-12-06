package kfu.itis.maslennikov.hw5.service;

import kfu.itis.maslennikov.hw5.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
}
