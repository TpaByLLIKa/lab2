package com.couce3.lab2.web.screens;

import com.couce3.lab2.service.RegistrationService;
import com.haulmont.cuba.core.global.Messages;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import javax.inject.Inject;

@UiController("lab2_RegistrationScreen")
@UiDescriptor("registration-screen.xml")
public class RegistrationScreen extends Screen {
    @Inject
    private TextField<String> loginField;
    @Inject
    private PasswordField passwordField;
    @Inject
    private Screens screens;
    @Inject
    private Notifications notifications;
    @Inject
    private Messages messages;
    @Inject
    private RegistrationService registrationService;
    @Inject
    private Logger log;

    @Subscribe("toLoginBtn")
    public void onToLoginBtnClick(Button.ClickEvent event) {
        screens.create(ExtLoginScreen.class, OpenMode.ROOT).show();
    }

    @Subscribe("submit")
    public void onSubmit(Action.ActionPerformedEvent event) {
        String login = loginField.getValue();
        String password = passwordField.getValue() != null ? passwordField.getValue() : "";

        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            notifications.create(Notifications.NotificationType.WARNING)
                    .withCaption(messages.getMainMessage("loginWindow.emptyLoginOrPassword"))
                    .show();
            return;
        }
        try {
            registrationService.register(login, password);

            ExtLoginScreen extLoginScreen = (ExtLoginScreen) screens.create(ExtLoginScreen.class, OpenMode.ROOT).show();
            extLoginScreen.showSuccessRegMsg();
            extLoginScreen.setLoginAndPass(login, password);
        } catch (Exception e) {
            if (e.getMessage().contains("idx_sec_user_uniq_login")) {
                notifications.create(Notifications.NotificationType.WARNING)
                        .withCaption("User with this login already exists")
                        .show();
                return;
            }
            log.error(e.getMessage(), e);
            notifications.create(Notifications.NotificationType.ERROR)
                    .withCaption(messages.getMainMessage("loginWindow.pleaseContactAdministrator"))
                    .show();
        }
    }
}