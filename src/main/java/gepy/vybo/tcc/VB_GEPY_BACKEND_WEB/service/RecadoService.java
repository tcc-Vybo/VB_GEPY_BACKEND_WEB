package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.service;

import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.dto.RecadoDTO;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.entity.RecadoEntity;
import gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.repository.RecadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecadoService {

    @Autowired
    private RecadoRepository recadoRepository;

    public List<RecadoDTO> listarTodos(){
        List<RecadoEntity> recado = recadoRepository.findAll();
        return recado.stream().map(RecadoDTO::new).toList();
    }

    public void inserir(RecadoDTO recado){
        RecadoEntity recadoEntity = new RecadoEntity(recado);
        recadoRepository.save(recadoEntity);
    }

    public RecadoDTO alterar(RecadoDTO recado){
        RecadoEntity recadoEntity = new RecadoEntity(recado);
        return new RecadoDTO(recadoRepository.save(recadoEntity));
    }

    public void excluir(Long id){
        RecadoEntity recado = recadoRepository.findById(id).get();
        recadoRepository.delete(recado);
    }
}
