package br.com.pessoal.projeto.repository;

import br.com.pessoal.projeto.entity.UsuarioVerificadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioVerificadorRepository extends JpaRepository<UsuarioVerificadorEntity, Long> {
    Optional<UsuarioVerificadorEntity> findByUuid(UUID uuid);
}
