package br.com.api.bancoDeSangue.services;

import br.com.api.bancoDeSangue.repositories.MediaIdadePorTipoSanguineoRepository;
import br.com.api.bancoDeSangue.responses.Response;

public class MediaIdadePorTipoSanguineoService {
	private MediaIdadePorTipoSanguineoRepository mediaIdadePorTipoSanguineoRepository;
	
	
	public MediaIdadePorTipoSanguineoService(){}
	
	
	public Response getMediaIdadePorTipoSanguineo() throws Exception {
		Response resposta = new Response();
		
		mediaIdadePorTipoSanguineoRepository = new MediaIdadePorTipoSanguineoRepository();
		resposta = mediaIdadePorTipoSanguineoRepository.getMediaIdadePorTipoSanguineo();
		
		return resposta;
	}
}
