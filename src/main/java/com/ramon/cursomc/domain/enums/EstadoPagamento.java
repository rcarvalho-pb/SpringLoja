package com.ramon.cursomc.domain.enums;

import java.util.List;
import java.util.stream.Stream;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;
    private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        if(cod == null) return null;

        return Stream.of(EstadoPagamento.values())
                .filter(estPag -> cod.equals(estPag.getCod()))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
