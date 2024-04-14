package br.com.ccs.contratocobrancaparcela.mappers;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * <p><b>Interface de contrato para implementação do Mappers customizados</b></p>
 *
 * <p>Mappers são nossas classes que transformam Entidades de Dominio de e para {@code RESPONSEMODEL} e
 * {@code INPUTMODEL} do core da API</p>
 *
 * @param <RESPONSEMODEL> Classe que representa um RESPONSE de uma Entidade de Domínio.
 * @param <INPUTMODEL>    Classe que representa um INPUT de uma Entidade de Domínio.
 * @param <ENTITY>        Classe que representa uma Entidade de Domínio.
 * @author Cleber Souza
 * @version 1.0
 * @since 21/08/2022
 */
public interface MapperInterface<RESPONSEMODEL, INPUTMODEL, ENTITY> {

    /**
     * <p><b>Transforma uma Entidade em ResponseModel</b></p>
     *
     * @param entity Entidade que será transformado.
     * @return {@code RESPONSEMODEL} Um novo ResponseModel.
     */
    RESPONSEMODEL toResponseModel(ENTITY entity);

    /**
     * <p><b>Transforma um InputModel em uma Entidade</b></p>
     *
     * @param inputmodel o inputmodel que sera transformado.
     * @return {@code ENTITY} Uma nova Entidade contendo os dados {@code INPUTMODEL}
     */
    ENTITY toEntity(INPUTMODEL inputmodel);

    /**
     * <p><b>Atualiza uma Entidade com os dados do InputModel
     *
     * @param inputmodel com os dados novos.
     * @param entity     a entidade que será atualizada.
     */
    void updateEntity(INPUTMODEL inputmodel, ENTITY entity);

    /**
     * <p><b>Transforma um {@code Page<Entity>} em um {@code Page<RESPONSEMODEL>}</b></p>
     *
     * @param page o Page contendo as entidades.
     * @return {@link Page<RESPONSEMODEL>}
     */
    default Page<RESPONSEMODEL> toPage(Page<ENTITY> page) {
        return page.map(this::toResponseModel);
    }

    /**
     * <p><b>Tranforma um {@code Page<ENTITY>} em uma Coleção de {@code RESPONSEMODEL}</b></p>
     *
     * @param page o page contendo a entidades.
     * @return {@link Collection<RESPONSEMODEL>} com as entidades transformadas em {@code RESPONSEMODEL}.
     */
    default Collection<RESPONSEMODEL> toCollection(Page<ENTITY> page) {

        return this.toCollection(page.getContent());

    }

    /**
     * <p><b>Transforma uma coleção de {@code ENTITY} em {@code RESPONSEMODEL} que representam
     * entidades de domínio</b></p>
     *
     * @param collection A coleção a ser transformada.
     * @return {@link Collection<RESPONSEMODEL>} A coleção transformada.
     */
    default Collection<RESPONSEMODEL> toCollection(Collection<ENTITY> collection) {
        return collection.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }
}

