package es.pratica.adocoes.aplicacao.dtos;


import es.pratica.adocoes.dominio.modelos.OngModel;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OngDto {
    private String id;
    private String cnpj;
    private String name;
    private String email;
    private String ddd;
    private String phone;
    private AddressDto addressDto;

    public OngDto(String cnpj, String name, String email, String ddd, String phone, AddressDto addressDto) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.ddd = ddd;
        this.phone = phone;
        this.addressDto = addressDto;
    }

    public static OngDto fromModel(OngModel model){
        return new OngDto(model.getId(), model.getCnpj(), 
                          model.getName(), model.getEmail(), model.getDdd(), 
                          model.getPhone(), AddressDto.fromModel(model.getAddressModel()));
    }

    public static OngModel toModel(OngDto dto){
        return new OngModel(dto.getCnpj(), dto.getName(), dto.getEmail(),
                            dto.getDdd(), dto.getPhone(), AddressDto.fromDto(dto.getAddressDto()));
    }
}
