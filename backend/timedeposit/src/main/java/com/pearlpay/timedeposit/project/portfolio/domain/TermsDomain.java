package com.pearlpay.timedeposit.project.portfolio.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "terms")
@Builder
public class TermsDomain {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",length = 11)
    private int id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "time_deposit_id")
    private TimeDepositAccountDomain timeDepositAccount;

    @Column(name = "no_of_terms", length = 11)
    private int numberOfTerms;

    @Column(name = "interest_rate",precision=8, scale=2)
    private float interestRate;
}
