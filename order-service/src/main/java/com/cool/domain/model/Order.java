package com.cool.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String orderNo;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;

}
