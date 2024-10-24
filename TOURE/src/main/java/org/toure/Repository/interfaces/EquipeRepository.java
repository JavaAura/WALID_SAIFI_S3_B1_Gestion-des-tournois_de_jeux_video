package org.toure.Repository.interfaces;

import org.toure.Model.Equipe;

import java.util.List;

public interface EquipeRepository {
    public Equipe create(Equipe equipe);

    public Equipe update(Equipe equipe, long id) ;
    public List<Equipe> getAll();

    public void delete(Long id);

}
