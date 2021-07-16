import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { refreshUserSession } from 'actions/userLogedIn.js';
import { Loader } from 'react-overlay-loader';
import {Grid, Row, Col} from "react-bootstrap";
import { Card } from "components/Card/Card.jsx";
import SimpleModal from "components/Modal/SimpleModal.jsx";
import UserDataService from 'service/UserDataService';
import Button from "components/CustomButton/CustomButton.jsx";
import DataTable from 'react-data-table-component';


class Home extends Component {
    constructor(props) {
        super(props)

        this.state = {
            loadingActive:false,
            divCandidatosPorEstado: false,
            divImcMedioPorFaixaDeIdade: false,
            divPercentualObesosHomensMulheres: false,
            divMediaIdadePorTipoSanguineo: false,
            divDoadoresParaCadaTipoSanguineo: false,
            faixa_inicial:'', 
            faixa_final:'',
            candidatosPorEstado:[],
            doadoresParaCadaTipoSanguineo:[],
            mediaIdadePorTipoSanguineo:[],
            percentualObesosHomensMulheres:[],
            imcMedioPorFaixaDeIdade:[],
        }

        this.getCandidatosPorEstado = this.getCandidatosPorEstado.bind(this)
        this.setFaixas = this.setFaixas.bind(this)
    }

    componentDidMount(){
        
    }

    setFaixas(e){
        if(e.target.value != 0){
            this.setState({
                faixa_inicial:parseInt(e.target.value),
                faixa_final:parseInt(e.target.value) + 9
            })
        }
        else{
            this.setState({
                faixa_inicial:0,
                faixa_final:0
            })
        }
    }

    getCandidatosPorEstado(){
        this.setState({loadingActive: true})
        UserDataService.getCandidatosPorEstado()
        .then(response => {
            this.setState({loadingActive: false})
            if(response.status === 200){
                if(response.data != null && response.data.data != null ){
                    if(response.data.data.candidatosPorEstado != null && response.data.data.candidatosPorEstado.length > 0){
                        this.setState({
                            candidatosPorEstado: response.data.data.candidatosPorEstado,
                            divCandidatosPorEstado: true,
                            divImcMedioPorFaixaDeIdade: false,
                            divPercentualObesosHomensMulheres: false,
                            divMediaIdadePorTipoSanguineo: false,
                            divDoadoresParaCadaTipoSanguineo: false,
                        })
                    }
                } 
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Por favor, tente novamente mais tarde.');
                console.log("retornou código: " + response.status);
            }
        })
        .catch(error => {
            this.setState({loadingActive: false})
            console.log(error.message);

            if(error.message.includes("401")){
                this.props.refreshUserSession(undefined, undefined);
                this.props.history.push('/');
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Descrição do erro: '+error.message);
            }
        })
    }

    getDoadoresParaCadaTipoSanguineo(){
        this.setState({loadingActive: true})
        UserDataService.getDoadoresParaCadaTipoSanguineo()
        .then(response => {
            this.setState({loadingActive: false})
            if(response.status === 200){
                if(response.data != null && response.data.data != null ){
                    if(response.data.data.doadoresParaCadaTipoSanguineo != null && response.data.data.doadoresParaCadaTipoSanguineo.length > 0){
                        this.setState({
                            doadoresParaCadaTipoSanguineo: response.data.data.doadoresParaCadaTipoSanguineo,
                            divDoadoresParaCadaTipoSanguineo: true,
                            divCandidatosPorEstado: false,
                            divImcMedioPorFaixaDeIdade: false,
                            divPercentualObesosHomensMulheres: false,
                            divMediaIdadePorTipoSanguineo: false,
                        })
                    }
                } 
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Por favor, tente novamente mais tarde.');
                console.log("retornou código: " + response.status);
            }
        })
        .catch(error => {
            this.setState({loadingActive: false})
            console.log(error.message);

            if(error.message.includes("401")){
                this.props.refreshUserSession(undefined, undefined);
                this.props.history.push('/');
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Descrição do erro: '+error.message);
            }
        })
    }

    getMediaIdadePorTipoSanguineo(){
        this.setState({loadingActive: true})
        UserDataService.getMediaIdadePorTipoSanguineo()
        .then(response => {
            this.setState({loadingActive: false})
            if(response.status === 200){
                if(response.data != null && response.data.data != null ){
                    if(response.data.data.mediaIdadePorTipoSanguineo != null && response.data.data.mediaIdadePorTipoSanguineo.length > 0){
                        this.setState({
                            mediaIdadePorTipoSanguineo: response.data.data.mediaIdadePorTipoSanguineo,
                            divDoadoresParaCadaTipoSanguineo: false,
                            divCandidatosPorEstado: false,
                            divImcMedioPorFaixaDeIdade: false,
                            divPercentualObesosHomensMulheres: false,
                            divMediaIdadePorTipoSanguineo: true,
                        })
                    }
                } 
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Por favor, tente novamente mais tarde.');
                console.log("retornou código: " + response.status);
            }
        })
        .catch(error => {
            this.setState({loadingActive: false})
            console.log(error.message);

            if(error.message.includes("401")){
                this.props.refreshUserSession(undefined, undefined);
                this.props.history.push('/');
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Descrição do erro: '+error.message);
            }
        })
    }

    getPercentualObesosHomensMulheres(){
        this.setState({loadingActive: true})
        UserDataService.getPercentualObesosHomensMulheres()
        .then(response => {
            this.setState({loadingActive: false})
            if(response.status === 200){
                if(response.data != null && response.data.data != null ){
                    if(response.data.data.percentualObesosHomensMulheres != null && response.data.data.percentualObesosHomensMulheres.length > 0){
                        this.setState({
                            percentualObesosHomensMulheres: response.data.data.percentualObesosHomensMulheres,
                            divDoadoresParaCadaTipoSanguineo: false,
                            divCandidatosPorEstado: false,
                            divImcMedioPorFaixaDeIdade: false,
                            divPercentualObesosHomensMulheres: true,
                            divMediaIdadePorTipoSanguineo: false,
                        })
                    }
                } 
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Por favor, tente novamente mais tarde.');
                console.log("retornou código: " + response.status);
            }
        })
        .catch(error => {
            this.setState({loadingActive: false})
            console.log(error.message);

            if(error.message.includes("401")){
                this.props.refreshUserSession(undefined, undefined);
                this.props.history.push('/');
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Descrição do erro: '+error.message);
            }
        })
    }

    getImcMedioPorFaixaDeIdade(){
        this.setState({loadingActive: true})
        UserDataService.getImcMedioPorFaixaDeIdade(this.state.faixa_inicial, this.state.faixa_final)
        .then(response => {
            this.setState({loadingActive: false})
            if(response.status === 200){
                if(response.data != null && response.data.data != null ){
                    if(response.data.data.imcMedioPorFaixaDeIdade != null && response.data.data.imcMedioPorFaixaDeIdade.length > 0){
                        this.setState({
                            imcMedioPorFaixaDeIdade: response.data.data.imcMedioPorFaixaDeIdade,
                            divDoadoresParaCadaTipoSanguineo: false,
                            divCandidatosPorEstado: false,
                            divImcMedioPorFaixaDeIdade: true,
                            divPercentualObesosHomensMulheres: false,
                            divMediaIdadePorTipoSanguineo: false,
                        })
                    }
                } 
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Por favor, tente novamente mais tarde.');
                console.log("retornou código: " + response.status);
            }
        })
        .catch(error => {
            this.setState({loadingActive: false})
            console.log(error.message);

            if(error.message.includes("401")){
                this.props.refreshUserSession(undefined, undefined);
                this.props.history.push('/');
            }
            else{
                this.refs.simpleModal.modalOpen('Ops!', 'Um erro ocorreu', 'Descrição do erro: '+error.message);
            }
        })
    }

    render() {
        const columnsCandidatosPorEstado = [
            {
                name: 'Estado',
                selector: 'estado',
                sortable: true
            },
            {
                name: 'Candidatos',
                selector: 'candidatos',
                sortable: true
            }
        ];

        const columnsDoadoresParaCadaTipoSanguineo = [
            {
                name: 'Tipo Sanguineo',
                selector: 'tipoSanguineo',
                sortable: true
            },
            {
                name: 'Doadores',
                selector: 'doadores',
                sortable: true
            }
        ];

        const columnsImcMedioPorFaixaDeIdade = [
            {
                name: 'IMC Medio por Faixa',
                selector: 'imcMedioFaixa',
                sortable: true
            }
        ];

        const columnsMediaIdadePorTipoSanguineo = [
            {
                name: 'Tipo Sanguineo',
                selector: 'tipoSanguineo',
                sortable: true
            },
            {
                name: 'Média Idade',
                selector: 'mediaIdade',
                sortable: true
            }
        ];

        const columnsPercentualObesosHomensMulheres = [
            {
                name: 'Sexo',
                selector: 'sexo',
                sortable: true
            },
            {
                name: 'Percentual Obesidade',
                selector: 'percentualObesidade',
                sortable: true
            }
        ];
        
        return (
            <div className="content">
                <SimpleModal ref="simpleModal" />
                <Loader fullPage loading={this.state.loadingActive} text=""/>

                <Grid fluid>
                    <Row>
                        <Col sm={12}>
                            <Card content={
                                <>
                                    <Row>
                                        <div>
                                            <i style={{fontSize:'large', paddingRight:'30px', paddingBottom:'20px'}} className='fa fa-search text-warning'/>
                                            <span style={{fontSize:'20px'}} className='title'>Pesquisa no Banco de Sangue</span>
                                        </div>
                                    </Row>
                                    <Row>
                                        <div style={{paddingBottom:'20px'}} className="col-md-12">
                                            <Button style={{marginRight:'10px',}} bsStyle="primary" fill type="button" onClick={(e) => {this.getCandidatosPorEstado(e)}}>Candidatos Por Estado</Button>
                                            <Button style={{marginRight:'10px',}} bsStyle="primary" fill type="button" onClick={(e) => {this.getDoadoresParaCadaTipoSanguineo(e)}}>Doadores Para Cada Tipo Sanguineo</Button>
                                            <Button style={{marginRight:'10px',}} bsStyle="primary" fill type="button" onClick={(e) => {this.getMediaIdadePorTipoSanguineo(e)}}>Média de Idade Por Tipo Sanguineo</Button>
                                            <Button style={{marginRight:'10px',}} bsStyle="primary" fill type="button" onClick={(e) => {this.getPercentualObesosHomensMulheres(e)}}>Percentual de Obesos Entre Homens e Mulheres</Button>
                                        </div>
                                    </Row>
                                    <Row>
                                        <div style={{paddingBottom:'20px'}} className="col-md-12">
                                            <select style={{width:'300px', float:'left'}} className="form-control" onChange={(e) => {this.setFaixas(e)}}>
                                                <option value="0"></option>
                                                <option value="1">0 a 10</option>
                                                <option value="11">11 a 20</option>
                                                <option value="21">21 a 30</option>
                                                <option value="31">31 a 40</option>
                                                <option value="41">41 a 50</option>
                                                <option value="51">51 a 60</option>
                                                <option value="71">71 a 80</option>
                                                <option value="81">81 a 90</option>
                                            </select>
                                            <Button  style={{marginLeft:'10px',}} bsStyle="primary" fill type="button" onClick={(e) => {this.getImcMedioPorFaixaDeIdade(e)}}>IMC Medio Por Faixa de Idade</Button>
                                        </div>
                                    </Row>
                                    <div style={{paddingTop:'10px', display:(this.state.divCandidatosPorEstado ? 'inline' : 'none')}}>
                                        <DataTable
                                            columns={columnsCandidatosPorEstado}
                                            data={this.state.candidatosPorEstado}
                                            highlightOnHover={true}
                                            noHeader={true}
                                            selectableRows={false}
                                            selectableRowsHighlight={false}
                                            pagination={true}
                                        />
                                    </div>
                                    <div style={{paddingTop:'10px', display:(this.state.divDoadoresParaCadaTipoSanguineo ? 'inline' : 'none')}}>
                                        <DataTable
                                            columns={columnsDoadoresParaCadaTipoSanguineo}
                                            data={this.state.doadoresParaCadaTipoSanguineo}
                                            highlightOnHover={true}
                                            noHeader={true}
                                            selectableRows={false}
                                            selectableRowsHighlight={false}
                                            pagination={true}
                                        />
                                    </div>
                                    <div style={{paddingTop:'10px', display:(this.state.divMediaIdadePorTipoSanguineo ? 'inline' : 'none')}}>
                                        <DataTable
                                            columns={columnsMediaIdadePorTipoSanguineo}
                                            data={this.state.mediaIdadePorTipoSanguineo}
                                            highlightOnHover={true}
                                            noHeader={true}
                                            selectableRows={false}
                                            selectableRowsHighlight={false}
                                            pagination={true}
                                        />
                                    </div>
                                    <div style={{paddingTop:'10px', display:(this.state.divPercentualObesosHomensMulheres ? 'inline' : 'none')}}>
                                        <DataTable
                                            columns={columnsPercentualObesosHomensMulheres}
                                            data={this.state.percentualObesosHomensMulheres}
                                            highlightOnHover={true}
                                            noHeader={true}
                                            selectableRows={false}
                                            selectableRowsHighlight={false}
                                            pagination={true}
                                        />
                                    </div>
                                    <div style={{paddingTop:'10px', display:(this.state.divImcMedioPorFaixaDeIdade ? 'inline' : 'none')}}>
                                        <DataTable
                                            columns={columnsImcMedioPorFaixaDeIdade}
                                            data={this.state.imcMedioPorFaixaDeIdade}
                                            highlightOnHover={true}
                                            noHeader={true}
                                            selectableRows={false}
                                            selectableRowsHighlight={false}
                                            pagination={true}
                                        />
                                    </div>
                                </>
                            }/>
                        </Col>
                    </Row>
                </Grid>
            </div>
        )
    }
}

const mapStateToProps = store => ({
    user: store.userSessionState.user,
    sessionTime: store.userSessionState.sessionTime
});

const mapDispatchToProps = dispatch => bindActionCreators({ refreshUserSession }, dispatch);
  
export default connect(mapStateToProps, mapDispatchToProps) (Home);