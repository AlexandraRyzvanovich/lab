package com.epam.esm.dao;

import java.security.cert.Certificate;
import java.util.List;

public interface CertificateDao {
    Certificate getById();
    List<Certificate> getAll();
    boolean update(Certificate certificate);
    boolean create(Certificate certificate);
    boolean delete(Certificate certificate);

}
