package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.MateriaDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.MateriaEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<MateriaDTO> listarMaterias(){
        List<MateriaEntity> materias = materiaRepository.findAll();
        return materias.stream().map(MateriaDTO::new).toList();
    }

    public void inserir(MateriaDTO materia){
        MateriaEntity materiaEntity = new MateriaEntity(materia);
        materiaRepository.save(materiaEntity);
    }

    public MateriaDTO alterar(MateriaDTO materia){
        MateriaEntity materiaEntity = new MateriaEntity(materia);
        return new MateriaDTO(materiaRepository.save(materiaEntity));
    }

    public void excluir(Long id){
        MateriaEntity materiaEntity = materiaRepository.findById(id).get();
        materiaRepository.delete(materiaEntity);
    }
}
