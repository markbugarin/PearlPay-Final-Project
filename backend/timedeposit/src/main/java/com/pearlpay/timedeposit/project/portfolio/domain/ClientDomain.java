package com.pearlpay.timedeposit.project.portfolio.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "client")
@Builder
public class ClientDomain {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",length = 11)
    private int id;

    @OneToMany(mappedBy = "clientDomain",fetch = LAZY)
    private List<TimeDepositAccount> timeDepositAccounts;

    @Column(name = "first_name", length = 30)
    private String firstName;

    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "phone_number", length = 11)
    private String phoneNumber;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;
}
