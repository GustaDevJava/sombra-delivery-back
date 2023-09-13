package com.sombra.delivery.gfcsrvsombradelivery.models.enuns;

public enum TipoProduto {

    CERVEJA(0, "CERVEJA"),
    REFRIGERANTE(1, "REFRIGERANTE"),
    POD(2, "POD"),
    SALGADOS(3, "SALGADOS");
    

    private Integer cod;
    private String descricao;

    private TipoProduto(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoProduto toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoProduto x : TipoProduto.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Produo inválida!" + cod);
	}
}
