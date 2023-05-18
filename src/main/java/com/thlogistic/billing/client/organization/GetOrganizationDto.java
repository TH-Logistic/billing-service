package com.thlogistic.billing.client.organization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOrganizationDto {
    String id;
    String name;
    String creditCard;
    String contactName;
    String contactNumber;
    Integer type;
    Integer providerType;
}
