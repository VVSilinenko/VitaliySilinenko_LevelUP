package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TrelloApiTestBase {

    TestProperties tp;

    @BeforeMethod
    public void setUp() {
        tp = new TestProperties();
    }

    // Удаление доски
    void deleteBoard(String id){
        Response delete = given()
                .baseUri(tp.getValue("url") + "/1/boards/" + id)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .delete();
        try {
            assertEquals(delete.getStatusCode(), 200);
        } catch (AssertionError e){
            System.err.format("Не удалось удалить доску");
        }
    }

    // Создание доски
    String getBoardId(){
        String nameOfBoard = "LevelUpBoard_" + new Date().getTime();
        JSONObject boardBody = new JSONObject().put("name", nameOfBoard);

        Response createBoard = given()
                .baseUri(tp.getValue("url") + "/1/boards/")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(boardBody.toString())
                .post();
        assertEquals(createBoard.getStatusCode(), 200);
        JSONObject createBoardResponse = new JSONObject(createBoard.asString());

        return createBoardResponse.getString("id");
    }

    // Создание колонки
    String getListId(String idBoard){
        JSONObject listBody = new JSONObject().put("name", "Test_List_1");
        Response createList = given()
                .baseUri(tp.getValue("url") + "/1/boards/" + idBoard + "/lists")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(listBody.toString())
                .post();
        assertEquals(createList.getStatusCode(), 200);
        JSONObject createListResponse = new JSONObject(createList.asString());

        return createListResponse.getString("id");
    }

    // Удаление тэга из организации
    void deleteTagFromOrganization(String organizationId, List<String> tagIdList){

        for (String tagId : tagIdList) {
            Response deleteTagsInOrganization = given()
                    .baseUri(tp.getValue("url") + "/1/organizations/" + organizationId + "/tags/" + tagId)
                    .queryParam("key", tp.getValue("key"))
                    .queryParam("token", tp.getValue("token"))
                    .delete();

            assertEquals(deleteTagsInOrganization.getStatusCode(), 200);
        }
    }


}
