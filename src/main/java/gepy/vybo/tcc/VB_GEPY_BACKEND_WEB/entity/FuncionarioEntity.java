package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.FuncionarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

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
    private String telefone;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String email;

    // Dados Profissionais
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cargo;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String departamento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String dataAdmissao;

    // Endereço Residencial
    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cep;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String endereco;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private int numero;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String complemento;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String bairro;

    @Pattern(regexp = "[^\"'<>*$]", message = "Caracteres especiais não são permitidos.")
    @Column(nullable = false)
    private String cidade;

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

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate(){
        if (this.nomeCompleto != null){
            this.nomeCompleto = this.nomeCompleto.toUpperCase();
        }
    }

    public FuncionarioEntity(FuncionarioDTO funcionario) {
        BeanUtils.copyProperties(funcionario, this);
    }
}
