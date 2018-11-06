package com.litbo.hospital.security.bean;

import lombok.Data;

@Data
public class MSreplicationOptions {
    private String optname;
    private String value;
    private Long majorVersion;
    private Long minorVersion;
    private Long revision;
    private Long installFailures;

}
