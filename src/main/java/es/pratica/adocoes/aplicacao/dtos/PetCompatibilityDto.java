package es.pratica.adocoes.aplicacao.dtos;

import es.pratica.adocoes.dominio.modelos.AnimalModel;

public record PetCompatibilityDto(
        AnimalModel pet,
        double score
) {}
