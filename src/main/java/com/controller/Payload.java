package com.controller;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Payload<E> {

    private List<E> entities;
    private Integer offset;
    private Integer limit;
    private Long count;
}
