package com.pearlpay.timedeposit.project.portfolio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "time_deposit_account")
@Builder
public class TimeDepositAccountDomain {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(fetch = LAZY, mappedBy = "timeDepositAccount")
    private List<TermsDomain> terms;


    @OneToMany(mappedBy = "timeDepositAccountDomain")
    private List<ViewAccountDomain> viewAccountDomains;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "client_id")
    private ClientDomain clientDomain;

    @Column(name = "account_number",length = 11)
    private String accountNumber;

    @Column(name = "balance",length = 11)
    private int balance;

    @Column(name = "account_status")
    private boolean accountStatus;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date createdAt;
}
