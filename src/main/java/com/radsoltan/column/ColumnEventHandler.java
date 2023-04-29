package com.radsoltan.column;

import com.radsoltan.user.User;
import com.radsoltan.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class ColumnEventHandler {
    private final UserRepository users;

    @Autowired
    public ColumnEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addUserBasedOnLoggedInUser(Column column) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        column.setUser(user);
    }
}
