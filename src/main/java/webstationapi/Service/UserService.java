package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webstationapi.Entity.User;
import webstationapi.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
