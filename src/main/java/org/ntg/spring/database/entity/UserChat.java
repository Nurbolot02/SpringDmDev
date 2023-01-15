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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_chat")
public class UserChat implements BaseEntity<Long> {
    @Id
    @SequenceGenerator(name = "users_chat_id_seq_gen", sequenceName = "users_chat_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_chat_id_seq_gen")
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    @ToString.Exclude
    private Chat chat;

    public void setUser(User user) {
        this.user = user;
        user.getUserChats().add(this);
    }

    public void setChat(Chat chat) {
        this.chat = chat;
//        chat.getUserChats().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserChat userChat = (UserChat) o;
        return id != null && Objects.equals(id, userChat.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
