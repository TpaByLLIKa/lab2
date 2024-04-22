package com.couce3.lab2.web.screens;

import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.app.login.LoginScreen;


@UiController("ext-login")
@UiDescriptor("ext-login-screen.xml")
public class ExtLoginScreen extends LoginScreen {

    @Subscribe("regBtn")
    public void onRegBtnClick(Button.ClickEvent event) {
        screens.create(RegistrationScreen.class, OpenMode.ROOT).show();
    }

    public void showSuccessRegMsg() {
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption("You are successfully registered")
                .show();
    }

    public void setLoginAndPass(String login, String pass) {
        loginField.setValue(login);
        passwordField.setValue(pass);
        rememberMeCheckBox.setValue(false);
    }
}