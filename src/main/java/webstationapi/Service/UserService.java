package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.Entity.User;
import webstationapi.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void getAll() {
        Iterable<User> all = this.userRepository.findAll();

        for (User a : all) {
            System.out.println("UUID => " + a.getId());
        }

    }

}
