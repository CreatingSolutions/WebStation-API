package webstationapi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.Role;
import webstationapi.Entity.User;
import webstationapi.Repository.UserRepository;
import webstationapi.Security.ApplicationPasswordEncoder;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    @Autowired
    private UserRepository userRepository;

    final ApplicationPasswordEncoder passwordEncoder;

    public User findByEmail(final String email) {
        return userRepository.findByEmailAddress(email);
    }

    @Transactional
    public User update(final User user) {
        if (userRepository.findByEmailAddress(user.getEmailAddress()) == null) {
            return null; // TODO : throws new Exception Custom
        }
        return userRepository.save(user);
    }

    // TODO : revoir quand EXception perso
    public User findById(Integer userId) {
        try {
            return userRepository.findById(userId).orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public User register(User user) {
        if (userRepository.findByEmailAddress(user.getEmailAddress()) != null) {
            return null; // TODO : throws Perso Exception
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return user;
    }
}
