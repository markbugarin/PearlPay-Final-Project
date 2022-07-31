package com.pearlpay.timedeposit.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "primary_account")
@Builder
public class PrimaryAccount {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "maturity_date", updatable = true)
    private Date maturityDate;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "interest")
    private float interest;

    @Column(name = "balance")
    private float balance;

    @OneToMany(mappedBy="primaryAccount")
    private List<SecondaryAccount> secondaryAccounts;

    @OneToOne(mappedBy = "primaryAccount")
    private Withdraw withdraw;
}
