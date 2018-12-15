package webstationapi.Service;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.UserRepository;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void before() {

    }

    @Test
    @Ignore
    public void findByEmail() {
        User user = new User();
        user.setEmailAddress("damien@gmail.com");
        user.setPassword("123456");
        user.setId(1);
        this.userRepository.save(user);
        user =  this.userService.findByEmail("damien@gmail.com");
        assertThat(user).isNotNull();
        assertThat(user.getEmailAddress()).isEqualTo("damien@gmail.com");

    }

    @Test(expected = WebStationException.class)
    @Ignore
    public void update_fail() {
        User user = new User();
        user.setEmailAddress("damiedadadadan@gmail.com");
        user.setPassword("123456");
        user.setId(1);
        this.userService.update(user);
    }

    @Test
    @Ignore
    public void findById() {
        User user = new User();
        user.setEmailAddress("damien@gmail.com");
        user.setPassword("123456");
        user.setId(1);
        this.userRepository.save(user);
       user =  this.userService.findById(1);
       assertThat(user).isNotNull();
       assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Ignore
    public void register() {

        User user = new User();
        user.setEmailAddress("damien@gmail.com");
        user.setPassword("123456");

        user = this.userService.register(user);
        assertThat(user.getEmailAddress()).isEqualTo("damien@gmail.com");
    }

    @Test(expected = WebStationException.class)
    @Ignore
    public void register_mail_already_use() {

        User user = new User();
        user.setEmailAddress("damien@gmail.com");
        user.setPassword("123456");

        user = this.userService.register(user);

        User user2 = new User();
        user2.setEmailAddress("damien@gmail.com");
        user2.setPassword("123456");
        user = this.userService.register(user);
    }
}