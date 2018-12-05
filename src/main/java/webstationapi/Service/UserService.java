package webstationapi.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.UserRepository;
import webstationapi.Security.ApplicationPasswordEncoder;

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
            throw new WebStationException("Mail doesn't match");
        }
        return userRepository.save(user);
    }
    
    public User findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new WebStationException("bad user"));
    }

    @Transactional
    public User register(User user) {
        if (userRepository.findByEmailAddress(user.getEmailAddress()) != null) {
            throw new WebStationException("Mail exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);

        return user;
    }
}
