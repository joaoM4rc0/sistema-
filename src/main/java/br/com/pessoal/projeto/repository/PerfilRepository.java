package br.com.pessoal.projeto.repository;

import br.com.pessoal.projeto.entity.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {
}
