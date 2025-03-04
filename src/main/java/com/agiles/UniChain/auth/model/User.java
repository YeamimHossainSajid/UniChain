package com.agiles.UniChain.auth.model;

import com.agiles.UniChain.feature.canteen.entity.Restaurant;
import com.agiles.UniChain.feature.student.entity.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String password;

    @OneToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToOne
    @JoinColumn(name = "student_id", unique = true)
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        if (student != null && student.getUser() != this) {
            student.setUser(this);
        }
    }
}

