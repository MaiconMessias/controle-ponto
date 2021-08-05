package com.dio.controleponto.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
//@Audited
@Entity
public class BancoHoras {
    @EmbeddedId
    private BancoHorasId bancoHorasId;
    @Column
    private LocalDateTime dataTrabalhada;
    @Column
    private BigDecimal quantidadeHoras;
    @Column
    private BigDecimal saldoHoras;
}
