package es.pratica.adocoes.dominio.modelos;

import es.pratica.adocoes.adaptadores.persistencia.entidades.AnimalEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimalModel {
    private String id;
    private StatusPetModel statusPet;
    private String nome;
    private int idade;
    private String caracteristicas;
    private boolean necessidadesEspeciais;
    private boolean tratamentoContinuo;
    private boolean doencaCronica;
    private boolean doencaIncuravel;
    private boolean seDaBemComAnimais;
    private boolean cuidadosConstantes;

    public AnimalModel(StatusPetModel statusPet, String nome, int idade, String caracteristicas,boolean necessidadesEspeciais,
            boolean tratamentoContinuo, boolean doencaCronica, boolean doencaIncuravel, boolean seDaBemComAnimais,
            boolean cuidadosConstantes) {
        this.statusPet = statusPet;
        this.nome = nome;
        this.idade = idade;
        this.caracteristicas = caracteristicas;
        this.necessidadesEspeciais = necessidadesEspeciais;
        this.tratamentoContinuo = tratamentoContinuo;
        this.doencaCronica = doencaCronica;
        this.doencaIncuravel = doencaIncuravel;
        this.seDaBemComAnimais = seDaBemComAnimais;
        this.cuidadosConstantes = cuidadosConstantes;
    }

    public static AnimalModel toModel(AnimalEntity animalEntity){
        return new AnimalModel(animalEntity.getId(), StatusPetModel.valueOf(animalEntity.getStatusPet().name()), animalEntity.getNome(),
                               animalEntity.getIdade(), animalEntity.getCaracteristicas(),animalEntity.isNecessidadesEspeciais(),
                               animalEntity.isTratamentoContinuo(),animalEntity.isDoencaCronica(),animalEntity.isDoencaIncuravel(),
                               animalEntity.isSeDaBemComAnimais(),animalEntity.isCuidadosConstantes());        
    }


}
