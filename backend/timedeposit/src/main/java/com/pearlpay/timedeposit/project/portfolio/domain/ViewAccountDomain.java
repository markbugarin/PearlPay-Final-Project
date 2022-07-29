package com.pearlpay.timedeposit.project.portfolio.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "viewAccount")
@Builder
public class ViewAccountDomain {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id",length = 11)
    private int id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "timde_deposit_id")
    private TimeDepositAccountDomain timeDepositAccountDomain;
}
