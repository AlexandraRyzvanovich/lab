package com.epam.esm.dao.mapper;

import com.epam.esm.entity.Certificate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificateMapper implements RowMapper<Certificate> {
    @Override
    public Certificate mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Certificate certificate = new Certificate();
        certificate.setId(resultSet.getInt("id"));
        certificate.setName(resultSet.getString("name"));
        certificate.setDescription(resultSet.getString("description"));
        certificate.setPrice(resultSet.getBigDecimal("price"));
        certificate.setCreationDate(resultSet.getDate("creation_date"));
        certificate.setModificationDate(resultSet.getDate("modification_date"));
        certificate.setValidDays(resultSet.getInt("valid_days"));

        return certificate;
    }
}
