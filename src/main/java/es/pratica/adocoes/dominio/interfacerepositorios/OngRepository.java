package es.pratica.adocoes.dominio.interfacerepositorios;

import java.util.Optional;

import es.pratica.adocoes.dominio.modelos.OngModel;

public interface OngRepository {
    public OngModel add(OngModel ongModel);
    public Optional<OngModel> getByCnpj(String cnpj);
}
