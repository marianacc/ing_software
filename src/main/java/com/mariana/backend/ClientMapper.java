package com.mariana.backend;

import org.apache.ibatis.annotations.Insert;

public interface ClientMapper {

    @Insert("INSERT INTO client (first_name, last_name, birth_date, status)\n" +
            "        VALUES (#{firstName}, #{lastName}, #{birthDate}, true)  ")
    void create(ClientDto clientDto);
}
