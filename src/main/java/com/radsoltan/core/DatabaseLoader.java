package com.radsoltan.core;

import com.radsoltan.column.Column;
import com.radsoltan.storey.Storey;
import com.radsoltan.storey.StoreyRepository;
import com.radsoltan.user.User;
import com.radsoltan.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final StoreyRepository storeys;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(StoreyRepository storeys, UserRepository users) {
        this.users = users;
        this.storeys = storeys;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // DUMMY DATA FOR DEBUGGING AND DEVELOPMENT
        String[] templates = {"First %s", "Second %s", "Third %s", "Fourth %s", "Fifth %s"};
        String[] locations = {"floor utility complex", "floor office building", "floor hall"};
        String[] horizontalGrid = {"A", "B", "C", "D", "E"};
        String[] verticalGrid = {"1", "2", "3", "4", "5"};
        List<User> userList = List.of(
                new User("sfraser", "Shep",  "Fraser", "password", new String[] {"ROLE_USER"}),
                new User("pnorman", "Paul",  "Norman", "password", new String[] {"ROLE_USER"}),
                new User("p_stick", "Peter",  "Stickman", "password", new String[] {"ROLE_USER"}),
                new User("s_stub", "Shivank",  "Stubbs", "password", new String[] {"ROLE_USER"}),
                new User("rsoltan", "Rad", "Soltan", "password", new String[] {"ROLE_USER", "ROLE_ADMIN"})
        );
        users.saveAll(userList);
        List<Storey> storeyList = new ArrayList<>();
        IntStream.range(0, 40)
                .forEach(i -> {
                    String template = templates[i % templates.length];
                    String location = locations[i % locations.length];
                    String description = String.format(template, location);
                    int height = getRandomNumber(3, 6) * 1000;
                    double area = getRandomNumber(10000, 50000);
                    Storey s = new Storey(description, height, area);
                    IntStream.range(0, 10)
                                    .forEach(j -> {
                                        String label = horizontalGrid[getRandomNumber(0, horizontalGrid.length)] + verticalGrid[getRandomNumber(0, verticalGrid.length)];
                                        Column c = new Column(label, getRandomNumber(5,15) * 50, getRandomNumber(5,15) * 50, 1000);
                                        c.setUser(userList.get(getRandomNumber(0, userList.size())));
                                        s.addColumn(c);
                                    });
                    storeyList.add(s);
                });
        storeys.saveAll(storeyList);
    }
}
