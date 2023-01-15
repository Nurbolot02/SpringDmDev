package org.ntg.spring.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User implements BaseEntity<Long> {
    @Id
    @SequenceGenerator(name = "users_id_seq_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq_gen")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    @ToString.Exclude
    private Company company;
    @Builder.Default
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<UserChat> userChats = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
