package MyService;

import authServiceConfiguration.authServiceConfiguration;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import health.TemplateHealthCheck;
import resources.authServiceResource;

public class authService extends Service<authServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new authService().run(args);
    }

    @Override
    public void initialize(Bootstrap<authServiceConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }

    @Override
    public void run(authServiceConfiguration configuration,
                    Environment environment) {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new authServiceResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));
    }

}
