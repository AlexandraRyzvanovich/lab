package com.epam.esm.dao.mapper;

import com.epam.esm.entity.CertificateTag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CertificateTagMapper implements RowMapper<CertificateTag> {
    @Override
    public CertificateTag mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CertificateTag certificateTag = new CertificateTag();
        certificateTag.setId(resultSet.getInt("id"));
        certificateTag.setTagName(resultSet.getString("tagName"));

        return certificateTag;
    }
}
