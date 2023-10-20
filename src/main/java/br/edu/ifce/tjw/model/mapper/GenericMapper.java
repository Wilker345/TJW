package br.edu.ifce.tjw.model.mapper;

public interface GenericMapper<M, D> {

    M toModel(D dto);
    D toDTO(M model);
}
