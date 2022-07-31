package com.pearlpay.timedeposit.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "secondary_account")
@Builder
public class SecondaryAccount {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy="secondaryAccount")
    private List<Withdraw> withdraws;

    @ManyToOne
    @JoinColumn(name="primary_account_id", nullable=true)
    private PrimaryAccount primaryAccount;

    @Column(name = "balance")
    private float balance;
}
