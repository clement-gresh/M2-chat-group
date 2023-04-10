package com.example.linker.service;

import com.example.linker.dto.GenericDto;
import com.example.linker.model.GenericModel;
import com.example.linker.payload.GenericPayload;
import com.example.linker.repository.GenericRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Data
//@Service
// abstract ?
public class GenericService<MODEL extends GenericModel, DTO extends GenericDto, PAYLOAD extends GenericPayload, T> {
    final Class<MODEL> modelParameterClass;
    final Class<DTO> dtoParameterClass;
    protected final GenericRepository<MODEL, T> repository;
    protected final ModelMapper modelMapper = new ModelMapper();

    public GenericService(Class<MODEL> modelParameterClass, Class<DTO> dtoParameterClass,
                          GenericRepository<MODEL, T> repository) {
        this.modelParameterClass = modelParameterClass;
        this.dtoParameterClass = dtoParameterClass;
        this.repository = repository;
    }
    
    public List<DTO> getAll(){
        Iterable<MODEL> iterableModels = repository.findAll();
        List<MODEL> listModel = new ArrayList<>();
        iterableModels.forEach(listModel::add);
        return listModel.stream().map(e -> modelMapper.map(e, dtoParameterClass)).collect(Collectors.toList());
    }

    public List<DTO> getAllById(final List<T> ids){
        Iterable<MODEL> iterableModels = repository.findAllById(ids);
        List<MODEL> listModel = new ArrayList<>();
        iterableModels.forEach(listModel::add);
        return listModel.stream().map(e -> modelMapper.map(e, dtoParameterClass)).collect(Collectors.toList());
    }

    public DTO get(final T id) {
        Optional<MODEL> model = repository.findById(id);
        return (model.isPresent()) ? modelMapper.map(model, dtoParameterClass) : null;
    }

    public DTO save(PAYLOAD payload) {
        MODEL model = repository.save(modelMapper.map(payload, modelParameterClass));
        return modelMapper.map(model, dtoParameterClass);
    }

    public void delete(final T id) {
        repository.deleteById(id);
    }
}
