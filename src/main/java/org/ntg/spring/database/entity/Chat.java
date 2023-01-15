package org.ntg.spring.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
public class Chat implements BaseEntity<Long> {
    @Id
    @SequenceGenerator(name = "chat_id_seq_gen", sequenceName = "chat_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_id_seq_gen")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "chat")
    @ToString.Exclude
    private List<UserChat> userChats = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Chat chat = (Chat) o;
        return id != null && Objects.equals(id, chat.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
