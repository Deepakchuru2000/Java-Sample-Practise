import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentRepository {
    private final List<Student> students;

    public StudentRepository(List<Student> students){
        this.students=ImmutableList.copyOf(students);
    }

    public List<Student> findAll(int size){
        return students.stream()
                .limit(size)
                .collect(Collectors.toList());
    }

    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }
}
