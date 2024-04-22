package com.couce3.lab2.service;

import com.haulmont.cuba.security.entity.User;

import javax.validation.constraints.NotNull;

public interface RegistrationService {
    String NAME = "lab2_RegistrationService";
    void register(@NotNull String login, @NotNull String password);
}