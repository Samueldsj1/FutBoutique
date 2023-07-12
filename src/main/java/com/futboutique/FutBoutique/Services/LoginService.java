package com.futboutique.FutBoutique.Services;
import com.futboutique.FutBoutique.Models.UserModel;
import com.futboutique.FutBoutique.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@EnableJpaRepositories
@Service
public class LoginService {

    @Autowired(required = true)
    UserRepository userRepository;


    public UserModel logar(UserModel userModel) {
        return userRepository.login(userModel.getEmail(), userModel.getPassword());
    }
}
