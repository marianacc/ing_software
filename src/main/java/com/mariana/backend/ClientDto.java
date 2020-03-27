package com.mariana.backend;

import java.util.Date;
import java.util.Objects;

/**
 * Representa a la tabla Client
 * DTO: Data Transfer Object
 * PJO: Plain Old Java Object
 */

public class ClientDto {
    private Integer clientId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Boolean status;
    private Integer txId;
    private Date txDate;
    private Integer txUserId;
    private String txHost;

    public ClientDto() {
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "clientId=" + clientId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", status=" + status +
                ", txId=" + txId +
                ", txDate=" + txDate +
                ", txUserId=" + txUserId +
                ", txHost='" + txHost + '\'' +
                '}';
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getTxId() {
        return txId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public Integer getTxUserId() {
        return txUserId;
    }

    public void setTxUserId(Integer txUserId) {
        this.txUserId = txUserId;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return clientId.equals(clientDto.clientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }
}




