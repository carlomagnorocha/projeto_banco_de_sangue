package br.com.api.bancoDeSangue.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * DoadoresParaCadaTipoSanguineo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T19:45:18.181Z[GMT]")


public class DoadoresParaCadaTipoSanguineo   {
  @JsonProperty("tipoSanguineo")
  private String tipoSanguineo = null;

  @JsonProperty("doadores")
  private Long doadores = null;

  public DoadoresParaCadaTipoSanguineo tipoSanguineo(String tipoSanguineo) {
    this.tipoSanguineo = tipoSanguineo;
    return this;
  }

  /**
   * Get tipoSanguineo
   * @return tipoSanguineo
   **/
  @Schema(description = "")
  
    public String getTipoSanguineo() {
    return tipoSanguineo;
  }

  public void setTipoSanguineo(String tipoSanguineo) {
    this.tipoSanguineo = tipoSanguineo;
  }

  public DoadoresParaCadaTipoSanguineo doadores(Long doadores) {
    this.doadores = doadores;
    return this;
  }

  /**
   * Get doadores
   * @return doadores
   **/
  @Schema(description = "")
  
    public Long getDoadores() {
    return doadores;
  }

  public void setDoadores(Long doadores) {
    this.doadores = doadores;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoadoresParaCadaTipoSanguineo doadoresParaCadaTipoSanguineo = (DoadoresParaCadaTipoSanguineo) o;
    return Objects.equals(this.tipoSanguineo, doadoresParaCadaTipoSanguineo.tipoSanguineo) &&
        Objects.equals(this.doadores, doadoresParaCadaTipoSanguineo.doadores);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoSanguineo, doadores);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DoadoresParaCadaTipoSanguineo {\n");
    
    sb.append("    tipoSanguineo: ").append(toIndentedString(tipoSanguineo)).append("\n");
    sb.append("    doadores: ").append(toIndentedString(doadores)).append("\n");
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
