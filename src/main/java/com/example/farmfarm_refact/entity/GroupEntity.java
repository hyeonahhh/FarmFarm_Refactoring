package com.example.farmfarm_refact.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@DynamicUpdate
@Table(name="group_table")
@Getter
@Setter
public class GroupEntity {
    @Id
    @GeneratedValue
    @Column(name="g_id")
    private Long gId;

    private int capacity;   // 0: 참여 불가능, 1: 참여 가능

    @CreationTimestamp
    private Timestamp created_at;

    private Timestamp closed_at;

    @ManyToOne
    @JoinColumn(name="product")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="user_1")
    private UserEntity user1;

    @ManyToOne
    @JoinColumn(name="user_2")
    private UserEntity user2;

    @JsonIgnore
    @OneToMany(mappedBy = "group")
    private List<OrderDetailEntity> orderDetails = new ArrayList<>();

    private int isClose;

    private int stock;  // 잔여 수량(각 팀은 농부가 지정한 공구 수량을 알아서 나눠서 사야 한다.)
}
