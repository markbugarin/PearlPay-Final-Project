package com.pearlpay.timedeposit.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "checking")
@Builder
public class Checking {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private float balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_account_id", referencedColumnName = "id")
    private PrimaryAccount primaryAccount;

    @ManyToOne
    @JoinColumn(name="secondary_account_id", nullable=true)
    private SecondaryAccount secondaryAccount;
}
