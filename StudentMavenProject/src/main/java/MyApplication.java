import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;


public class MyApplication extends Application<BasicConfiguration> {

    public static void main(String[] args) throws Exception {
        new MyApplication().run("server", "local-config.yaml");
    }

    @Override
    public void run(BasicConfiguration basicConfiguration, Environment environment) {
        int defaultSize = basicConfiguration.getDefaultSize();
        StudentRepository StudentRepository = new StudentRepository(initStudents());
        StudentResource brandResource = new StudentResource(defaultSize, StudentRepository);

        environment
                .jersey()
                .register(brandResource);
    }

    @Override
    public void initialize(Bootstrap<BasicConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        super.initialize(bootstrap);
    }

    public List<Student> initStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(21L, "Ramesh",18L,345L));
        students.add(new Student(31L, "Komal",19L,356L));
        students.add(new Student(41L, "Siddharth",23L,432L));
        return students;
    }

}