//package com.spring.Hello_Events;
//
//import com.spring.Hello_Events.enums.Role;
//import com.spring.Hello_Events.model.User;
//import com.spring.Hello_Events.repository.UserRepository;
//import com.spring.Hello_Events.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class UserServiseTest {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
////
//    @Test
//    void testSave() {
//
//        User user = new User();
//        user.setUsername("saidtalfana");
//        user.setPassword("said123");
//
//        String encodedPassword = "said123";
//        when(passwordEncoder.encode("said123")).thenReturn(encodedPassword);
//        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        User result = userService.save(user);
//
//        assertNotNull(result);
//        assertEquals("saidtalfana", result.getUsername());
//        assertEquals(encodedPassword, result.getPassword());
//
//        Set<Role> expectedRoles = new HashSet<>();
//        expectedRoles.add(Role.ROLE_USER);
//        assertEquals(expectedRoles, result.getRoles());
//
//        verify(userRepository).save(result);
//    }
//
//
//    @Test
//    void testFindByUsername() {
//        String username = "saidtalfana";
//        User user = new User();
//        user.setUsername(username);
//
//        when(userRepository.findByUsername(username)).thenReturn(user);
//
//        User result = userService.findByUsername(username);
//
//        assertNotNull(result);
//        assertEquals(username, result.getUsername());}
//
//    @Test
//    void testFindAll() {
//        List<User> users = new ArrayList<>();
//        users.add(new User());
//        users.add(new User());
//
//        when(userRepository.findAll()).thenReturn(users);
//
//        List<User> result = userService.findAll();
//
//        assertNotNull(result);
//        assertEquals(2, result.size());
//    }
//
//    @Test
//    void testFindById() {
//        int id = 1;
//        User user = new User();
//        user.setId(id);
//
//        when(userRepository.findById(id)).thenReturn(Optional.of(user));
//
//        User result = userService.findById(id);
//
//        assertNotNull(result);
//        assertEquals(id, result.getId());
//    }
//    @Test
//    void testFindByIdNotFound() {
//        int id = 1;
//
//        when(userRepository.findById(id)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            userService.findById(id);
//        });
//
//        assertEquals("User not found", exception.getMessage());
//    }
//
//    @Test
//    void testUpdate() {
//        int id = 1;
//        User existingUser = new User();
//        existingUser.setId(id);
//        existingUser.setUsername("saidtalfana");
//        existingUser.setPassword("said123");
//        existingUser.setEmail("saidtalfana@gmail.com");
//        existingUser.setPhoneNumber("0600112233");
//        existingUser.setRoles(new HashSet<>());
//
//        User updatedUser = new User();
//        updatedUser.setUsername("talfanasaid");
//        updatedUser.setPassword("123said");
//        updatedUser.setEmail("talfanasaid@gmail.com");
//        updatedUser.setPhoneNumber("0733221100");
//        updatedUser.setRoles(new HashSet<>());
//
//        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
//        when(passwordEncoder.encode("123said")).thenReturn("123said");
//        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));
//
//        User result = userService.update(id, updatedUser);
//
//        assertNotNull(result);
//        assertEquals("talfanasaid", result.getUsername());
//        assertEquals("123said", result.getPassword());
//        assertEquals("talfanasaid@gmail.com", result.getEmail());
//        assertEquals("0733221100", result.getPhoneNumber());
//        assertEquals(existingUser.getId(), result.getId());
//    }
//}
