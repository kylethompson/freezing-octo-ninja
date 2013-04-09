package authServiceConfiguration;

import com.yammer.dropwizard.config.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Environment;
import health.TemplateHealthCheck;
import org.hibernate.validator.constraints.NotEmpty;
import resources.authServiceResource;

public class authServiceConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String template;

    @NotEmpty
    @JsonProperty
    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
   }
}
