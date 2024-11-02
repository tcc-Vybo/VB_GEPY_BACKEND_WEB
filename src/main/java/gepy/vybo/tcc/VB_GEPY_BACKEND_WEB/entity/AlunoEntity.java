package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.AlunoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table (name = "aluno")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    // Identificação
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String nomeCompleto;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String dataNascimento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cidadeNascimento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String ufNascimento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String nacionalidade;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String genero;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String corRaca;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String necessidades;

    // Endereço
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cep;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String endereco;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private int numeroEndereco;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    private String complemento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String bairro;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String municipio;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String uf;

    // RG
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String numeroRegistro;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cpf;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String dataEmissao;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String orgaoExpedidor;

    // Contato Aluno
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String telefoneAluno;

    // Contato Responsáveis
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String nomeResponsavel;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cpfResponsavel;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String relacao;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String telefoneResponsavel;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String emailResponsavel;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nomeCompleto != null){
            this.nomeCompleto = this.nomeCompleto.toUpperCase();
        }
    }

    public AlunoEntity(AlunoDTO aluno) {
        BeanUtils.copyProperties(aluno, this);
    }
}
