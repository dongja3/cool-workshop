package com.cool.domain.event;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private String orderNo;
}
