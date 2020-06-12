//package com.epam.esm.dao;
//
//import com.epam.esm.entity.Certificate;
//import com.epam.esm.dao.mapper.CertificateMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class CertificateDaoImpl implements CertificateDao {
//    JdbcTemplate jdbcTemplate;
//
//    private final String SQL_FIND_CERTIFICATE = "select * from certificate where id = ?";
//    private final String SQL_DELETE_CERTIFICATE = "delete from certificate where id = ?";
//    private final String SQL_UPDATE_CERTIFICATE = "update certificate set name = ?, description = ?, price  = ?, creation_date = ?, modification_date = ?, valid_days = ? where id = ?";
//    private final String SQL_GET_ALL = "select * from people";
//    private final String SQL_INSERT_CERTIFICATE = "insert into certificate(id, name, description, price, creation_date, modification_date, valid_days ) values(?,?,?,?,?,?,?)";
//
//    @Autowired
//    public CertificateDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    @Override
//    public Certificate getById(int id) {
//        return jdbcTemplate.queryForObject(SQL_FIND_CERTIFICATE, new Object[] { id }, new CertificateMapper());;
//    }
//
//    @Override
//    public List<Certificate> getAll() {
//        return jdbcTemplate.query(SQL_GET_ALL, new CertificateMapper());
//    }
//
//    @Override
//    public boolean update(Certificate certificate) {
//        return jdbcTemplate.update(SQL_UPDATE_CERTIFICATE, certificate.getName(), certificate.getDescription(), certificate.getPrice(), certificate.getCreationDate(),
//                certificate.getModificationDate(), certificate.getValidDays(),
//                certificate.getId()) > 0; }
//
//    @Override
//    public boolean create(Certificate certificate) {
//        return jdbcTemplate.update(SQL_INSERT_CERTIFICATE, certificate.getName(), certificate.getDescription(), certificate.getPrice(), certificate.getCreationDate(),
//                certificate.getModificationDate(), certificate.getValidDays(),
//                certificate.getPrice()) > 0;
//    }
//
//    @Override
//    public boolean delete(Certificate certificate) {
//        return jdbcTemplate.update(SQL_DELETE_CERTIFICATE, certificate.getId()) > 0;
//    }
//}
