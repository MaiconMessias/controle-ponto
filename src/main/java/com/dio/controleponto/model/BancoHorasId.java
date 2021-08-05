package com.dio.controleponto.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Embeddable
public class BancoHorasId implements Serializable {
    @Column(name = "id")
    private Long id;
    @ManyToOne
    private Movimentacao movimentacao;
}
