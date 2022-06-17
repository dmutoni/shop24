package com.example.shop24.seeders;

import com.example.shop24.enums.EGender;
import com.example.shop24.models.Client;
import com.example.shop24.repositories.ClientRepository;
import com.example.shop24.repositories.DrinkRepository;
import com.example.shop24.repositories.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder {
    private Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private final ClientRepository clientRepository;
    private final DrinkRepository drinkRepository;
    private final OrderRepository orderRepository;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(ClientRepository clientRepository, DrinkRepository drinkRepository, OrderRepository orderRepository, JdbcTemplate jdbcTemplate) {
        this.clientRepository = clientRepository;
        this.drinkRepository = drinkRepository;
        this.orderRepository = orderRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedClientTable();
    }
    private  void seedClientTable() {
        String sql = "SELECT * FROM clients_tbl";
        List<Client> clients = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (clients == null || clients.size() <= 0) {
            Client client1 = new Client(12.2, 12.2 ,"John", "Doe", "john@gmail.com", "john", EGender.MALE );
            Client client2 = new Client(12.2, 12.2 ,"Mutoni", "Denyse", "denyse@gmail.com", "denyse", EGender.FEMALE);
            Client client3 = new Client(12.2, 12.2 , "Egide", "Ntwali", "ntwali@gmail.com", "ntwali", EGender.MALE);
            clientRepository.save(client1);
            clientRepository.save(client2);
            clientRepository.save(client3);
            logger.info("Client table seeded");
        } else {
            logger.trace("Client seeding not required");
        }
    }
    private  void seedDrinkTable() {
        String sql = "SELECT * FROM clients_tbl";
        List<Client> clients = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (clients == null || clients.size() <= 0) {
            Client client1 = new Client(12.2, 12.2 ,"John", "Doe", "john@gmail.com", "john", EGender.MALE );
            Client client2 = new Client(12.2, 12.2 ,"Mutoni", "Denyse", "denyse@gmail.com", "denyse", EGender.FEMALE);
            Client client3 = new Client(12.2, 12.2 , "Egide", "Ntwali", "ntwali@gmail.com", "ntwali", EGender.MALE);
            clientRepository.save(client1);
            clientRepository.save(client2);
            clientRepository.save(client3);
            logger.info("Client table seeded");
        } else {
            logger.trace("Client seeding not required");
        }
    }
}
