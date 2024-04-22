package framework.rest.models;

import framework.Config;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class FrontAuth {
    private String usernameOrEmail;
    private String password;

    public static FrontAuth getBaseUserCredentials() {
        return FrontAuth.builder()
                .usernameOrEmail(Config.baseUserLogin)
                .password(Config.baseUserPassword)
                .build();
    }

}
