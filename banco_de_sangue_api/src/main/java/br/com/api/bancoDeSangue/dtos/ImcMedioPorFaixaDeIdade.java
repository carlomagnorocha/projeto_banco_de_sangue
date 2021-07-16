package br.com.api.bancoDeSangue.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ImcMedioPorFaixaDeIdade
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T19:45:18.181Z[GMT]")


public class ImcMedioPorFaixaDeIdade   {
  @JsonProperty("imcMedioFaixa")
  private Long imcMedioFaixa = null;

  public ImcMedioPorFaixaDeIdade imcMedioFaixa(Long imcMedioFaixa) {
    this.imcMedioFaixa = imcMedioFaixa;
    return this;
  }

  /**
   * Get imcMedioFaixa
   * @return imcMedioFaixa
   **/
  @Schema(description = "")
  
    public Long getImcMedioFaixa() {
    return imcMedioFaixa;
  }

  public void setImcMedioFaixa(Long imcMedioFaixa) {
    this.imcMedioFaixa = imcMedioFaixa;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ImcMedioPorFaixaDeIdade imcMedioPorFaixaDeIdade = (ImcMedioPorFaixaDeIdade) o;
    return Objects.equals(this.imcMedioFaixa, imcMedioPorFaixaDeIdade.imcMedioFaixa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imcMedioFaixa);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImcMedioPorFaixaDeIdade {\n");
    
    sb.append("    imcMedioFaixa: ").append(toIndentedString(imcMedioFaixa)).append("\n");
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
