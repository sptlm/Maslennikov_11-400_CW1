package kfu.itis.maslennikov.hw7.service;

import kfu.itis.maslennikov.hw7.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getByLogin(String login);
}
