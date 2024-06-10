package com.tobeto.blog.entity.concretes;

import com.tobeto.blog.entity.abstracts.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
