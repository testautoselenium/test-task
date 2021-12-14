package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface ProjectConfig extends Config {
    @Key("baseURL")
    String baseURL();

    @Key("loginEmail")
    String loginEmail();

    @Key("loginPassword")
    String loginPassword();

}
