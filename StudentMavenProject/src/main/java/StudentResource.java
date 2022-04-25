import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    private final int defaultSize;
    private final StudentRepository studentRepository;

    public StudentResource(int defaultSize, StudentRepository studentRepository) {
        this.defaultSize = defaultSize;
        this.studentRepository = studentRepository;
    }

    @GET
    public List<Student> getStudents(@QueryParam("size") Optional<Integer> size) {
        return studentRepository.findAll(size.orElse(defaultSize));
    }

    @GET
    @Path("/{id}")
    public Student getById(@PathParam("id") Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
    }
}