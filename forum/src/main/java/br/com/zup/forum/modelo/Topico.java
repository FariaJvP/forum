package br.com.zup.forum.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topico {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@Enumerated(EnumType.STRING)
	private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

	@ManyToOne
	private Usuario autor;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "topico")
	private List<Resposta> respostas = new ArrayList<>();

	@Deprecated
	public Topico(){
		//construtor padrão
	}

    // construtor para o formulário dto de entrada
	public Topico(String titulo, String mensagem, Curso nomeCurso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = nomeCurso;
    }

    //metodo que substitui os setters e possibilita alteração do titulo e mensagem do topico
    public void atualiza(String titulo, String mensagem){
		this.titulo = titulo;
		this.mensagem = mensagem;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public StatusTopico getStatus() {
		return status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public List<Resposta> getRespostas() {
		return respostas;
	}
}
