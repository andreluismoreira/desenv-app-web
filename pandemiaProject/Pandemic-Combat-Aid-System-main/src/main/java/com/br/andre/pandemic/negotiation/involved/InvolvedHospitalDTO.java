package com.br.andre.pandemic.negotiation.involved;

import com.br.andre.pandemic.item.Item;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InvolvedHospitalDTO {

    @NotBlank
    private Long idHospital;
    @NotBlank
    private List<Item> items;
}
