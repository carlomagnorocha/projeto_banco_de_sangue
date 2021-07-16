import axios from 'axios'

let BANCO_DE_SANGUE_URL = "http://localhost:8081/api_banco_de_sangue";

class UserDataService {

    getCandidatosPorEstado(){
        return axios.get(`${BANCO_DE_SANGUE_URL}/candidatosPorEstado`);
    }

    getDoadoresParaCadaTipoSanguineo(){
        return axios.get(`${BANCO_DE_SANGUE_URL}/doadoresParaCadaTipoSanguineo`);
    }

    getImcMedioPorFaixaDeIdade(faixaInicial, faixaFinal){
        return axios.get(`${BANCO_DE_SANGUE_URL}/imcMedioPorFaixaDeIdade`, {params: {faixa_inicial:faixaInicial, faixa_final:faixaFinal}});
    }

    getMediaIdadePorTipoSanguineo(){
        return axios.get(`${BANCO_DE_SANGUE_URL}/mediaIdadePorTipoSanguineo`);
    }

    getPercentualObesosHomensMulheres(){
        return axios.get(`${BANCO_DE_SANGUE_URL}/percentualObesosHomensMulheres`);
    }
}

export default new UserDataService()