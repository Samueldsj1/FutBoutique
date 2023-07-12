package com.futboutique.FutBoutique.Services;
import com.futboutique.FutBoutique.Models.UserModel;
import com.futboutique.FutBoutique.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }


    public Optional<UserModel> findById(Integer id){
        return userRepository.findById(id);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

}