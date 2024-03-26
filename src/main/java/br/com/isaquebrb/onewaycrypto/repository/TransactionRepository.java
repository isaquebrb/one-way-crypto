package br.com.isaquebrb.onewaycrypto.repository;

import br.com.isaquebrb.onewaycrypto.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
