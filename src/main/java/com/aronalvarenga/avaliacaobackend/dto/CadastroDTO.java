package com.aronalvarenga.avaliacaobackend.dto;

import com.aronalvarenga.avaliacaobackend.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CadastroDTO {

    private Pessoa pessoa;
}
