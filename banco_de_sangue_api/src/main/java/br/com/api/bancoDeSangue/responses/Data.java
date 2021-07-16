package br.com.api.bancoDeSangue.responses;

import java.util.Objects;
import br.com.api.bancoDeSangue.dtos.CandidatosPorEstado;
import br.com.api.bancoDeSangue.dtos.DoadoresParaCadaTipoSanguineo;
import br.com.api.bancoDeSangue.dtos.ImcMedioPorFaixaDeIdade;
import br.com.api.bancoDeSangue.dtos.MediaIdadePorTipoSanguineo;
import br.com.api.bancoDeSangue.dtos.PercentualObesosHomensMulheres;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Data
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T20:03:04.165Z[GMT]")


public class Data   {
  @JsonProperty("candidatosPorEstado")
  @Valid
  private List<CandidatosPorEstado> candidatosPorEstado = null;

  @JsonProperty("imcMedioPorFaixaDeIdade")
  @Valid
  private List<ImcMedioPorFaixaDeIdade> imcMedioPorFaixaDeIdade = null;

  @JsonProperty("percentualObesosHomensMulheres")
  @Valid
  private List<PercentualObesosHomensMulheres> percentualObesosHomensMulheres = null;

  @JsonProperty("mediaIdadePorTipoSanguineo")
  @Valid
  private List<MediaIdadePorTipoSanguineo> mediaIdadePorTipoSanguineo = null;

  @JsonProperty("doadoresParaCadaTipoSanguineo")
  @Valid
  private List<DoadoresParaCadaTipoSanguineo> doadoresParaCadaTipoSanguineo = null;

  public Data candidatosPorEstado(List<CandidatosPorEstado> candidatosPorEstado) {
    this.candidatosPorEstado = candidatosPorEstado;
    return this;
  }

  public Data addCandidatosPorEstadoItem(CandidatosPorEstado candidatosPorEstadoItem) {
    if (this.candidatosPorEstado == null) {
      this.candidatosPorEstado = new ArrayList<CandidatosPorEstado>();
    }
    this.candidatosPorEstado.add(candidatosPorEstadoItem);
    return this;
  }

  /**
   * Get candidatosPorEstado
   * @return candidatosPorEstado
   **/
  @Schema(description = "")
      @Valid
    public List<CandidatosPorEstado> getCandidatosPorEstado() {
    return candidatosPorEstado;
  }

  public void setCandidatosPorEstado(List<CandidatosPorEstado> candidatosPorEstado) {
    this.candidatosPorEstado = candidatosPorEstado;
  }

  public Data imcMedioPorFaixaDeIdade(List<ImcMedioPorFaixaDeIdade> imcMedioPorFaixaDeIdade) {
    this.imcMedioPorFaixaDeIdade = imcMedioPorFaixaDeIdade;
    return this;
  }

  public Data addImcMedioPorFaixaDeIdadeItem(ImcMedioPorFaixaDeIdade imcMedioPorFaixaDeIdadeItem) {
    if (this.imcMedioPorFaixaDeIdade == null) {
      this.imcMedioPorFaixaDeIdade = new ArrayList<ImcMedioPorFaixaDeIdade>();
    }
    this.imcMedioPorFaixaDeIdade.add(imcMedioPorFaixaDeIdadeItem);
    return this;
  }

  /**
   * Get imcMedioPorFaixaDeIdade
   * @return imcMedioPorFaixaDeIdade
   **/
  @Schema(description = "")
      @Valid
    public List<ImcMedioPorFaixaDeIdade> getImcMedioPorFaixaDeIdade() {
    return imcMedioPorFaixaDeIdade;
  }

  public void setImcMedioPorFaixaDeIdade(List<ImcMedioPorFaixaDeIdade> imcMedioPorFaixaDeIdade) {
    this.imcMedioPorFaixaDeIdade = imcMedioPorFaixaDeIdade;
  }

  public Data percentualObesosHomensMulheres(List<PercentualObesosHomensMulheres> percentualObesosHomensMulheres) {
    this.percentualObesosHomensMulheres = percentualObesosHomensMulheres;
    return this;
  }

  public Data addPercentualObesosHomensMulheresItem(PercentualObesosHomensMulheres percentualObesosHomensMulheresItem) {
    if (this.percentualObesosHomensMulheres == null) {
      this.percentualObesosHomensMulheres = new ArrayList<PercentualObesosHomensMulheres>();
    }
    this.percentualObesosHomensMulheres.add(percentualObesosHomensMulheresItem);
    return this;
  }

  /**
   * Get percentualObesosHomensMulheres
   * @return percentualObesosHomensMulheres
   **/
  @Schema(description = "")
      @Valid
    public List<PercentualObesosHomensMulheres> getPercentualObesosHomensMulheres() {
    return percentualObesosHomensMulheres;
  }

  public void setPercentualObesosHomensMulheres(List<PercentualObesosHomensMulheres> percentualObesosHomensMulheres) {
    this.percentualObesosHomensMulheres = percentualObesosHomensMulheres;
  }

  public Data mediaIdadePorTipoSanguineo(List<MediaIdadePorTipoSanguineo> mediaIdadePorTipoSanguineo) {
    this.mediaIdadePorTipoSanguineo = mediaIdadePorTipoSanguineo;
    return this;
  }

  public Data addMediaIdadePorTipoSanguineoItem(MediaIdadePorTipoSanguineo mediaIdadePorTipoSanguineoItem) {
    if (this.mediaIdadePorTipoSanguineo == null) {
      this.mediaIdadePorTipoSanguineo = new ArrayList<MediaIdadePorTipoSanguineo>();
    }
    this.mediaIdadePorTipoSanguineo.add(mediaIdadePorTipoSanguineoItem);
    return this;
  }

  /**
   * Get mediaIdadePorTipoSanguineo
   * @return mediaIdadePorTipoSanguineo
   **/
  @Schema(description = "")
      @Valid
    public List<MediaIdadePorTipoSanguineo> getMediaIdadePorTipoSanguineo() {
    return mediaIdadePorTipoSanguineo;
  }

  public void setMediaIdadePorTipoSanguineo(List<MediaIdadePorTipoSanguineo> mediaIdadePorTipoSanguineo) {
    this.mediaIdadePorTipoSanguineo = mediaIdadePorTipoSanguineo;
  }

  public Data doadoresParaCadaTipoSanguineo(List<DoadoresParaCadaTipoSanguineo> doadoresParaCadaTipoSanguineo) {
    this.doadoresParaCadaTipoSanguineo = doadoresParaCadaTipoSanguineo;
    return this;
  }

  public Data addDoadoresParaCadaTipoSanguineoItem(DoadoresParaCadaTipoSanguineo doadoresParaCadaTipoSanguineoItem) {
    if (this.doadoresParaCadaTipoSanguineo == null) {
      this.doadoresParaCadaTipoSanguineo = new ArrayList<DoadoresParaCadaTipoSanguineo>();
    }
    this.doadoresParaCadaTipoSanguineo.add(doadoresParaCadaTipoSanguineoItem);
    return this;
  }

  /**
   * Get doadoresParaCadaTipoSanguineo
   * @return doadoresParaCadaTipoSanguineo
   **/
  @Schema(description = "")
      @Valid
    public List<DoadoresParaCadaTipoSanguineo> getDoadoresParaCadaTipoSanguineo() {
    return doadoresParaCadaTipoSanguineo;
  }

  public void setDoadoresParaCadaTipoSanguineo(List<DoadoresParaCadaTipoSanguineo> doadoresParaCadaTipoSanguineo) {
    this.doadoresParaCadaTipoSanguineo = doadoresParaCadaTipoSanguineo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Data data = (Data) o;
    return Objects.equals(this.candidatosPorEstado, data.candidatosPorEstado) &&
        Objects.equals(this.imcMedioPorFaixaDeIdade, data.imcMedioPorFaixaDeIdade) &&
        Objects.equals(this.percentualObesosHomensMulheres, data.percentualObesosHomensMulheres) &&
        Objects.equals(this.mediaIdadePorTipoSanguineo, data.mediaIdadePorTipoSanguineo) &&
        Objects.equals(this.doadoresParaCadaTipoSanguineo, data.doadoresParaCadaTipoSanguineo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(candidatosPorEstado, imcMedioPorFaixaDeIdade, percentualObesosHomensMulheres, mediaIdadePorTipoSanguineo, doadoresParaCadaTipoSanguineo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Data {\n");
    
    sb.append("    candidatosPorEstado: ").append(toIndentedString(candidatosPorEstado)).append("\n");
    sb.append("    imcMedioPorFaixaDeIdade: ").append(toIndentedString(imcMedioPorFaixaDeIdade)).append("\n");
    sb.append("    percentualObesosHomensMulheres: ").append(toIndentedString(percentualObesosHomensMulheres)).append("\n");
    sb.append("    mediaIdadePorTipoSanguineo: ").append(toIndentedString(mediaIdadePorTipoSanguineo)).append("\n");
    sb.append("    doadoresParaCadaTipoSanguineo: ").append(toIndentedString(doadoresParaCadaTipoSanguineo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
