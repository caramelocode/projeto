package br.org.carameloCode.erp.modulo.projeto.entidadesJPA.projetoBuilderCRC.itemProjeto;

import jakarta.json.JsonObject;

/**
 *
 * @author salvio
 */
public class UtilProjCRCJson {

    public JsonObject getJsonByObjeto(ComoItemProjeto pItem) {
        // UtilCRCJson.gerarJsonByEntidadeSimplesLasyMode(pItem);

        return (JsonObject) pItem;
    }

    public ComoItemProjeto getItemByJson(JsonObject pJson) {

        String tipoItem = pJson.getString("tipoItemProj");
        FabTipoItemProjeto tipo = null;//obter tipo pelo TipoItem
        ComoItemProjeto item = tipo.getItemByJson(pJson);

        return item;
    }

}
