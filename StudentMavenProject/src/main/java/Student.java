public class Student {
    private final Long id;
    private final String name;
    private final Long age;
    private final Long marks;

    public Student(Long id, String name, Long age, Long marks){
        this.id=id;
        this.name=name;
        this.age=age;
        this.marks=marks;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Long getAge(){
        return age;
    }
    public Long getMarks(){
        return marks;
    }
}
