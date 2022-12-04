package peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "company_gen")
    @SequenceGenerator(name = "company_gen",sequenceName = "company_gen", allocationSize = 1)
    private Long id;
    @Column(length =  100000, name = "company_name")
    private String companyName;
    @Column(length = 100000, name = "located_country")
    private String locatedCountry;

    private int numberOfStudents = 0;

    public void minusStudents(){
        numberOfStudents--;
    }

    public void plusStudents(){
        numberOfStudents++;
    }

    @OneToMany(cascade = {MERGE,DETACH,PERSIST,REFRESH}, fetch = FetchType.LAZY,mappedBy = "company")
    private List<Course> courseList;

    public void addCourse(Course course){
        if (courseList == null){
            courseList = new ArrayList<>();
        }
        courseList.add(course);
    }
}
