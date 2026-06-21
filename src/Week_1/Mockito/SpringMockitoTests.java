package Week_1.Mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = new User(1L, "Kartik");
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        User result = userService.getUserById(1L);
        assertEquals("Kartik", result.getName());
    }

    @Test
    public void testGetUserByIdNotFound() {
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.empty());
        assertThrows(NoSuchElementException.class, () -> userService.getUserById(1L));
    }
}

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }
}

@SpringBootTest(classes = Week_1.Application.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser() throws Exception {
        User user = new User(1L, "Kartik");
        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kartik"));
    }

    @Test
    public void testGetUserNotFound() throws Exception {
        when(userService.getUserById(1L)).thenThrow(new NoSuchElementException("User not found"));

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }

    @Test
    public void testCreateUser() throws Exception {
        User user = new User(1L, "Kartik");
        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Kartik\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Kartik"));
    }
}

@SpringBootTest(classes = Week_1.Application.class)
@AutoConfigureMockMvc
class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFullFlow() throws Exception {
        userRepository.deleteAll();

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":100,\"name\":\"IntegrationTestUser\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/users/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("IntegrationTestUser"));
    }
}

class ParameterizedTestJUnit {

    @ParameterizedTest
    @ValueSource(strings = {"apple", "banana", "cherry"})
    public void testStrings(String input) {
        assertTrue(input.length() > 0);
    }
}
