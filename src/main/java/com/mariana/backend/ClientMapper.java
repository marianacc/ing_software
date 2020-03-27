package com.mariana.backend;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ClientMapper {

    @Insert("INSERT INTO client (first_name, last_name, birth_date, status)\n" +
            "        VALUES (#{firstName}, #{lastName}, #{birthDate}, true)  ")
    void create(ClientDto clientDto);

    @Select(" SELECT client_id as clientId, first_name as firstName, " +
            " last_name as lastName, birth_date as birthDate, status," +
            " tx_id as txId, tx_date as txDate, tx_user_id as txUserId, tx_host as txHost " +
            " FROM client " +
            " WHERE status = true "
    )
    List<ClientDto> listAll();

    @Update(" UPDATE client SET status = false WHERE client_id = #{clientId}")
    void deleteClient(Integer clientId);

    @Update(" UPDATE client " +
            "SET " +
            "   first_name = #{firstName}," +
            "   last_name =  #{lastName}," +
            "   birth_date =  #{birthDate} " +
            "   WHERE client_id = #{clientId} ")
    void updateClient(ClientDto clientDto);
}
