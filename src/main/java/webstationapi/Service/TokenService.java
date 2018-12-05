package webstationapi.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webstationapi.DTO.TokenDTO;
import webstationapi.Entity.Token;
import webstationapi.Repository.TokenRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TokenService {

    private final TokenRepository tokenRepository;

    public Token save(final Token token) {
        return tokenRepository.save(token);
    }

    public void delete(final Token token) {
        tokenRepository.delete(token);
    }

    public void deleteFrom(final TokenDTO user) {
        String t = user.getToken();
        Token token = tokenRepository.findByApplicationToken(user.getToken());


        //final Token token = tokenRepository.findByUser(user);
        if (token == null) {
            System.out.println("pas possible de logout non co user");
            return;
        }

        tokenRepository.delete(token);
    }
}
