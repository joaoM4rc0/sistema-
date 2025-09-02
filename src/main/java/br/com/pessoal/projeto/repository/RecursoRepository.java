package br.com.pessoal.projeto.repository;

import br.com.pessoal.projeto.entity.RecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long> {
}
