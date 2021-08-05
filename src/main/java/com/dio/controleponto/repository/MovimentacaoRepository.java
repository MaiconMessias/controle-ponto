package com.dio.controleponto.repository;

import com.dio.controleponto.model.Movimentacao;
import com.dio.controleponto.model.MovimentacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {
    List<Movimentacao> findByMovimentacaoIdId(Long id);
    @Transactional
    @Modifying
    @Query("delete from Movimentacao m where m.movimentacaoId.id = :pId")
    int deleteMovi(@Param("pId") Long id);
}