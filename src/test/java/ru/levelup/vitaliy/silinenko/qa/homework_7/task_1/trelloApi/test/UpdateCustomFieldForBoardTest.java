package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateCustomFieldForBoardTest extends TrelloApiTestBase {

    @Test
    public void updateCustomFieldForBoardTest(){
        String boardId = getBoardId();
        String pluginId = "56d5e249a98895a9797bebb9";

        // Добавление плагина на доску
        JSONObject addCustomFieldsPluginBody = new JSONObject()
                .put("idPlugin", pluginId);
        Response addCustomField = given()
                .baseUri(tp.getValue("url") + "/1/boards/" + boardId + "/boardPlugins")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(addCustomFieldsPluginBody.toString())
                .post();
        assertEquals(addCustomField.getStatusCode(), 200);

        // Создание customField
        JSONObject createCustomFieldBody = new JSONObject()
                .put("idModel", boardId)
                .put("modelType", "board")
                .put("name", "Field_1")
                .put("type", "number")
                .put("pos", "bottom");
        Response createCustomField = given()
                .baseUri(tp.getValue("url") + "/1/customFields/")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(createCustomFieldBody.toString())
                .post();
        assertEquals(createCustomField.getStatusCode(), 200);
        JSONObject createCustomFieldResponseBody = new JSONObject(createCustomField.asString());
        String customFieldId = createCustomFieldResponseBody.getString("id");

        // Проверки
        Response getCustomField = given()
                .baseUri(tp.getValue("url") + "/1/customFields/" + customFieldId)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .get();
        assertEquals(getCustomField.getStatusCode(), 200);
        JSONObject getCustomFieldResponseBody = new JSONObject(getCustomField.asString());
        String name = getCustomFieldResponseBody.getString("name");
        String type = getCustomFieldResponseBody.getString("type");
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(name, "Field_1");
        sa.assertEquals(type, "number");

        // Обновление customField
        JSONObject updateCustomFieldBody = new JSONObject()
                .put("name", "Field_2");
        Response updateCustomField = given()
                .baseUri(tp.getValue("url") + "/1/customFields/" + customFieldId)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(updateCustomFieldBody.toString())
                .put();
        assertEquals(updateCustomField.getStatusCode(), 200);

        // Проверки
        Response getUpdateCustomField = given()
                .baseUri(tp.getValue("url") + "/1/customFields/" + customFieldId)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .get();
        assertEquals(getUpdateCustomField.getStatusCode(), 200);
        JSONObject getUpdateCustomFieldResponseBody = new JSONObject(getUpdateCustomField.asString());
        String newName = getUpdateCustomFieldResponseBody.getString("name");
        sa.assertEquals(newName, "Field_1");
        sa.assertEquals(type, "number");

        // Удаление доски
        deleteBoard(boardId);
    }
}
