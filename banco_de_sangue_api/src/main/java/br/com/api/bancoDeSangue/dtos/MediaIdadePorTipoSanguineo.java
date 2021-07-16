package br.com.api.bancoDeSangue.dtos;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MediaIdadePorTipoSanguineo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-07-15T19:45:18.181Z[GMT]")


public class MediaIdadePorTipoSanguineo   {
  @JsonProperty("tipoSanguineo")
  private String tipoSanguineo = null;

  @JsonProperty("mediaIdade")
  private Long mediaIdade = null;

  public MediaIdadePorTipoSanguineo tipoSanguineo(String tipoSanguineo) {
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

  public MediaIdadePorTipoSanguineo mediaIdade(Long mediaIdade) {
    this.mediaIdade = mediaIdade;
    return this;
  }

  /**
   * Get mediaIdade
   * @return mediaIdade
   **/
  @Schema(description = "")
  
    public Long getMediaIdade() {
    return mediaIdade;
  }

  public void setMediaIdade(Long mediaIdade) {
    this.mediaIdade = mediaIdade;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MediaIdadePorTipoSanguineo mediaIdadePorTipoSanguineo = (MediaIdadePorTipoSanguineo) o;
    return Objects.equals(this.tipoSanguineo, mediaIdadePorTipoSanguineo.tipoSanguineo) &&
        Objects.equals(this.mediaIdade, mediaIdadePorTipoSanguineo.mediaIdade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tipoSanguineo, mediaIdade);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MediaIdadePorTipoSanguineo {\n");
    
    sb.append("    tipoSanguineo: ").append(toIndentedString(tipoSanguineo)).append("\n");
    sb.append("    mediaIdade: ").append(toIndentedString(mediaIdade)).append("\n");
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
