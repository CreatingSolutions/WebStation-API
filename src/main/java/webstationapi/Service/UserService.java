package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import webstationapi.Entity.User;
import webstationapi.Exception.WebStationException;
import webstationapi.Repository.UserRepository;
import webstationapi.Security.ApplicationPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationPasswordEncoder passwordEncoder;
    
    @Autowired
    private CartService cartService;

    public User findByEmail(final String email) {
        return userRepository.findByEmailAddress(email);
    }

    @Transactional
    public User update(final User user) {
        if (userRepository.findByEmailAddress(user.getEmailAddress()) == null) {
            throw new WebStationException("Mail does not match");
        }
        return userRepository.save(user);
    }

    public User findById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new WebStationException("No user found with this ID"));
    }

    @Transactional
    public User register(User user) {
        if (userRepository.findByEmailAddress(user.getEmailAddress()) != null) {
            throw new WebStationException("Mail already used");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        
        cartService.createNewCart(user);
        
        return user;
    }
    
}
