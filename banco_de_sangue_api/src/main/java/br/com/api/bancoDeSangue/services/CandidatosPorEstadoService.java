package br.com.api.bancoDeSangue.services;

import br.com.api.bancoDeSangue.repositories.CandidatosPorEstadoRepository;
import br.com.api.bancoDeSangue.responses.Response;

public class CandidatosPorEstadoService {
	private CandidatosPorEstadoRepository candidatosPorEstadoRepository;
	
	
	public CandidatosPorEstadoService(){}
	
	
	public Response getCandidatosPorEstado() throws Exception {
		Response resposta = new Response();
		
		candidatosPorEstadoRepository = new CandidatosPorEstadoRepository();
		resposta = candidatosPorEstadoRepository.getCandidatosPorEstado();
		
		return resposta;
	}

}
