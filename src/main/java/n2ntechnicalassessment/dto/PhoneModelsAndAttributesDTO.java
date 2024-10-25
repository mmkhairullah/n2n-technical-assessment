package n2ntechnicalassessment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneModelsAndAttributesDTO {

    private String model;
    private String displaySize;
    private String displayType;
    private String weight;


    public PhoneModelsAndAttributesDTO(String model, String displaySize, String displayType, String weight) {
        this.model = model;
        this.displaySize = displaySize;
        this.displayType = displayType;
        this.weight = weight;
    }

}
