package kfu.itis.maslennikov.util;

public record AppConfig(String DBUrl, String DBUser, String DBPassword, String FilesDirectory, String cloud_name, String api_key, String api_secret) {}
