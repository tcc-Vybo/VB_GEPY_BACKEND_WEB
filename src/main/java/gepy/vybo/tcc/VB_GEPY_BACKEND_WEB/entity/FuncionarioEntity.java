package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Dados Pessoais
    @NotBlank
    @Column(nullable = false)
    private String nomeCompleto;

    @NotBlank
    @Column(nullable = false)
    private String dataNascimento;

    @NotBlank
    @Column(nullable = false)
    private String cidadeNascimento;

    @NotBlank
    @Column(nullable = false)
    private String ufNascimento;

    @NotBlank
    @Column(nullable = false)
    private String nacionalidade;

    @NotBlank
    @Column(nullable = false)
    private String genero;

    @NotBlank
    @Column(nullable = false)
    private String corRaca;

    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotBlank
    @Column(nullable = false)
    private String email;

    // Endereço Residencial
    @NotBlank
    @Column(nullable = false)
    private String cep;

    @NotBlank
    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private int numero;

    private String complemento;

    @NotBlank
    @Column(nullable = false)
    private String bairro;

    @NotBlank
    @Column(nullable = false)
    private String cidade;

    @NotBlank
    @Column(nullable = false)
    private String uf;

    // RG
    @NotBlank
    @Column(nullable = false)
    private String numeroRegistro;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String dataEmissao;

    @NotBlank
    @Column(nullable = false)
    private String orgaoExpedidor;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nomeCompleto != null){
            this.nomeCompleto = this.nomeCompleto.toUpperCase();
        }
    }

    @OneToMany(mappedBy = "professor")
    private List<ProfessorDisciplinaEntity> disciplinas;

    public FuncionarioEntity(FuncionarioDTO funcionario) {
        BeanUtils.copyProperties(funcionario, this);
    }
}
