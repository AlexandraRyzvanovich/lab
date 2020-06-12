package com.epam.esm.entity;

public class CertificateForSale {
    private int id; // вместо этого настройка
    private int certificate;
    private int certificateTag;

    public CertificateForSale() {
    }

    public CertificateForSale(int id, int certificate, int certificateTag) {
        this.id = id;
        this.certificate = certificate;
        this.certificateTag = certificateTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCertificate() {
        return certificate;
    }

    public void setCertificate(int certificate) {
        this.certificate = certificate;
    }

    public int getCertificateTag() {
        return certificateTag;
    }

    public void setCertificateTag(int certificateTag) {
        this.certificateTag = certificateTag;
    }
}
