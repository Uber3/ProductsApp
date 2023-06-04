package com.example.demo.Controller;

import com.example.demo.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.*;

/*
 * @author Dzmitry Rusak
 * @link
 */
@ExtendWith(MockitoExtension.class)
@WebMvcTest(OrderController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest

class OrderControllerTest {

    @Autowired
 //   private MockMVC mockMVC;

    @MockBean
    private OrderService orderService;

    @Test
    void getAll() {

    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }
}