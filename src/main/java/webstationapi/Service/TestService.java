package webstationapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.Entity.Test;
import webstationapi.Repository.TestRepository;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void addTest() {

        Test test = new Test();
        testRepository.save(test);
    }

    public List<Test> getAll(){
        return (List<Test>) testRepository.findAll();
    }

}
