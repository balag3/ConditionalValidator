package com.example.dto;

import com.example.enums.ExportLocationOption;
import org.junit.Before;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ExportLocationDTOTest {

    private Validator validator;

    private ExportLocationDTO dto;

    @Before
    public void setUp() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();

        dto = ExportLocationDTO.builder()
                .name("validName")
                .build();
    }

    @Test
    public void ShouldFailOnMissingEmailAddressField() {
        dto.setLocationOption(ExportLocationOption.EMAIL);
        Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto);
        assertEquals(1, violations.size());
    }

    @Test
    public void ShouldFailOnMissingFTPCredentials() {
        dto.setLocationOption(ExportLocationOption.FTP);
        Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto);
        assertEquals(4, violations.size());
    }

    @Test
    public void ShouldFailOnMissingSFTPCredentials() {
        dto.setLocationOption(ExportLocationOption.SFTP);
        Set<ConstraintViolation<ExportLocationDTO>> violations = validator.validate(dto);
        assertEquals(4, violations.size());
    }
}