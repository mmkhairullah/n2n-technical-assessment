package n2ntechnicalassessment.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Customers extends BaseEntity {

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "office_number")
    private String officeNumber;

    @Column(name = "family_member")
    private Integer familyMember;

    @Column(name = "date_joined")
    private Date dateJoined;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    private Products products;

}
