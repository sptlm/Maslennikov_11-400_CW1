package kfu.itis.maslennikov.web.service;

import kfu.itis.maslennikov.web.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getByLogin(String login);
}
