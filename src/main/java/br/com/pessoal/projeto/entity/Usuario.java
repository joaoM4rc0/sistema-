package br.com.pessoal.projeto.entity;

import java.util.Objects;

@Entity
@Table(name = "JM_USUARIO")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String login;
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private String email;
	public Usuario(UsuarioDto usuario) {
		BeanUtils.copyProperties(usuario, this);
	}
	
	public Usuario() {
	}

	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}


}
