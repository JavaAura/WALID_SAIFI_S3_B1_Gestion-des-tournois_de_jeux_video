package org.toure.Service;

import org.toure.Model.Equipe;
import org.toure.Repository.interfaces.EquipeRepository;

import java.util.List;

public class EquipeService {
    private  final  EquipeRepository equipeRepository;

    public EquipeService(EquipeRepository equipeRepository) {

        this.equipeRepository = equipeRepository;
    }
    public Equipe ajouterEquipe(Equipe equipe){
        return  equipeRepository.create(equipe);
    }
    public  Equipe ModifierEquipe(Equipe equipe,long id){
        return  equipeRepository.update(equipe,id);
    }
    public  void SuppremeEquipe(long id){
        equipeRepository.delete(id);
    }
    public List<Equipe> getAllEquipe(){
        return     equipeRepository.getAll();
    }
    public  Equipe getbyname(String name){
        return  equipeRepository.getByName(name);
    }
}
