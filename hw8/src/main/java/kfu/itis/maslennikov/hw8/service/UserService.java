package kfu.itis.maslennikov.hw8.service;

import kfu.itis.maslennikov.hw8.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getByLogin(String login);
}
