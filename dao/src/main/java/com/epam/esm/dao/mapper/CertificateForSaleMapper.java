package com.epam.esm.dao.mapper;

import com.epam.esm.entity.CertificateForSale;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificateForSaleMapper implements RowMapper<CertificateForSale> {
    @Override
    public CertificateForSale mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CertificateForSale certificateForSale = new CertificateForSale();
        certificateForSale.setId(resultSet.getInt("id"));
        certificateForSale.setCertificate(resultSet.getInt("certificateId"));
        certificateForSale.setCertificateTag(resultSet.getInt("tagId"));

        return certificateForSale;
    }
}
