package com.demo.enums;

public enum TipoEnum {
	INICIO_TRABALHO("Inicio do trabalho",1),
	TERMINO_TRABALHO("Termino do trabalho",2),
	INICIO_ALMOCO("Inicio do almoço",3),
	TERMINO_ALMOCO("Termido do almoço",4),
	INICIO_PAUSA("Inicio da pausa",5),
	TERMINO_PAUSA("Termino da pausa",6);
	
	private int codigo;
	private String descricao;

	private TipoEnum(String descricao, int codigo) {
		this.setDescricao(descricao);
		this.setCodigo(codigo);
		
	}

	public static TipoEnum getByCodigo(int cod) {
		if(cod <= 0 || cod > 6) {
			return null;
		}
		for(TipoEnum tipo : TipoEnum.values()) {
			if(tipo.codigo == cod)
				return tipo;
		}
		return null;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
