package com.dio.controleponto.repository;


import com.dio.controleponto.model.BancoHoras;
import com.dio.controleponto.model.BancoHorasId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHorasId> {
    List<BancoHoras> findByBancoHorasIdId(Long id);
    @Transactional
    @Modifying
    @Query("delete from BancoHoras b where b.bancoHorasId.id = :pId")
    int deleteBancoHoras(@Param("pId") Long id);
}
