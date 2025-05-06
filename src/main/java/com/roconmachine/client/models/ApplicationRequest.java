package com.roconmachine.client.models;

import com.roconmachine.client.core.AppRequest;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ApplicationRequest extends AppRequest {

    private String javaVersion;
    private String version;  //consider as spring version

    private String serviceName;
    private String serviceDescription;

    private String groupId;
    private String artifaactId;
    private String packaging;

}
