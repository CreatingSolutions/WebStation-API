package webstationapi.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Token;
import webstationapi.Repository.TokenRepository;

@Service
public class TokenService {

	@Autowired
    private TokenRepository tokenRepository;

    public Token save(final Token token) {
        return tokenRepository.save(token);
    }

    public void delete(final Token token) {
        tokenRepository.delete(token);
    }

    public void deleteFrom(final TokenDTO user) {
        Token token = tokenRepository.findByApplicationToken(user.getToken());

        //final Token token = tokenRepository.findByUser(user);
        if (token == null) {
            System.out.println("User has already logged out");
            return;
        }

        tokenRepository.delete(token);
    }
}
