package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateTagForBoardTest extends TrelloApiTestBase{

    @Test
    public void createTagForBoardTest() {

        // Создание доски в организации
        String organizationId = "5ed9541ddd1fdd100e70570c";
        String nameOfBoard = "LevelUpBoardInOrganization_" + new Date().getTime();
        JSONObject boardBody = new JSONObject()
                .put("name", nameOfBoard)
                .put("idOrganization", organizationId);

        Response createBoardInOrganization = given()
                .baseUri(tp.getValue("url") + "/1/boards/")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(boardBody.toString())
                .post();

        assertEquals(createBoardInOrganization.getStatusCode(), 200);
        JSONObject createBoardInOrganizationResponseBody = new JSONObject(createBoardInOrganization.asString());

        // Создание тега организации
        String tagName = "TestTag_" + new Date().getTime();
        JSONObject tagOrganizationBody = new JSONObject()
                .put("name", tagName)
                .put("id", organizationId);

        Response createTagInOrganization = given()
                .baseUri(tp.getValue("url") + "/1/organizations/" + organizationId + "/tags")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(tagOrganizationBody.toString())
                .post();

        assertEquals(createTagInOrganization.getStatusCode(), 200);
        JSONObject createTagInOrganizationResponseBody = new JSONObject(createTagInOrganization.asString());
        String tagId = createTagInOrganizationResponseBody.getString("id");

        // Проверки
        Response getTagsInOrganization = given()
                .baseUri(tp.getValue("url") + "/1/organizations/" + organizationId + "/tags")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .get();

        assertEquals(getTagsInOrganization.getStatusCode(), 200);
        JSONArray getTagsInOrganizationResponseBody = new JSONArray(getTagsInOrganization.asString());
        List<String> tagsList = new ArrayList<>();
        String actualTagId = null;
        for (int i = 0; i < getTagsInOrganizationResponseBody.length(); i++){
            tagsList.add(getTagsInOrganizationResponseBody.getJSONObject(i).getString("id"));
            if (getTagsInOrganizationResponseBody.getJSONObject(i).getString("name").equals(tagName)) {
                actualTagId = getTagsInOrganizationResponseBody.getJSONObject(i).getString("id");
            }
        }
        assertEquals(actualTagId, tagId);

        // Создание тега доски
        String boardId = createBoardInOrganizationResponseBody.getString("id");
        JSONObject tagBoardBody = new JSONObject().put("value", tagId);

        Response createTagInBoard = given()
                .baseUri(tp.getValue("url") + "/1/boards/" + boardId + "/idTags")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(tagBoardBody.toString())
                .post();

        assertEquals(createTagInBoard.getStatusCode(), 200);

        // Удаление всех тэгов
        deleteTagFromOrganization(organizationId, tagsList);

        // Удаление доски
        deleteBoard(boardId);

    }
}
