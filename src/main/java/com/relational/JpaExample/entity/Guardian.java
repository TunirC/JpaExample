package com.relational.JpaExample.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "guardian_first_name")),
        @AttributeOverride(name = "lastName", column = @Column(name = "guardian_last_name")),
        @AttributeOverride(name = "emailId", column = @Column(name = "guardian_email_id")),
        @AttributeOverride(name = "phone", column = @Column(name = "guardian_phone_number"))
})
public class Guardian {
    private String firstName;
    private String lastName;
    private String emailId;
    private String phone;
}
