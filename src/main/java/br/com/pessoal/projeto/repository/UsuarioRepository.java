package br.com.pessoal.projeto.repository;

import br.com.pessoal.projeto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
