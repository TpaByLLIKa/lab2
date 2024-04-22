package com.couce3.lab2.service;

import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PasswordEncryption;
import com.haulmont.cuba.security.entity.Group;
import com.haulmont.cuba.security.entity.User;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Service(RegistrationService.NAME)
public class RegistrationServiceBean implements RegistrationService {

    @Inject
    private PasswordEncryption passwordEncryption;
    @Inject
    private Metadata metadata;
    @Inject
    private Persistence persistence;

    @Override
    public void register(@NotNull String login, @NotNull String password) {
        Transaction tx = persistence.getTransaction();
        try {
            EntityManager em = persistence.getEntityManager();

            User user = metadata.create(User.class);
            user.setLogin(login);

            String passwordHash = passwordEncryption.getPasswordHash(user.getId(), password);
            user.setPassword(passwordHash);

            Group group = em.createQuery("select g from sec$Group g " +
                    "where g.name = 'Simple Group'", Group.class).getSingleResult();
            user.setGroup(group);

            em.persist(user);

            tx.commit();
        } finally {
            tx.end();
        }
    }
}