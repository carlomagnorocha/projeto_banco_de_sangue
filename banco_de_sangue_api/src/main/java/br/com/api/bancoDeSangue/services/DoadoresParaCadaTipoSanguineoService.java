package br.com.api.bancoDeSangue.services;

import br.com.api.bancoDeSangue.repositories.DoadoresParaCadaTipoSanguineoRepository;
import br.com.api.bancoDeSangue.responses.Response;


public class DoadoresParaCadaTipoSanguineoService {
	private DoadoresParaCadaTipoSanguineoRepository doadoresParaCadaTipoSanguineoRepository;
	
	
	public DoadoresParaCadaTipoSanguineoService(){}
	
	
	public Response getDoadoresParaCadaTipoSanguineo() throws Exception {
		Response resposta = new Response();
		
		doadoresParaCadaTipoSanguineoRepository = new DoadoresParaCadaTipoSanguineoRepository();
		resposta = doadoresParaCadaTipoSanguineoRepository.getDoadoresParaCadaTipoSanguineo();
		
		return resposta;
	}
}
