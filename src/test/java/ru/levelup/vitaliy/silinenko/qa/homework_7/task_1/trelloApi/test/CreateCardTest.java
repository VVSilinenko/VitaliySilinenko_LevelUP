package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateCardTest extends TrelloApiTestBase {

    @Test
    public void createCardTest(){
        String boardId = getBoardId();

        // Создание карточки в колонке
        JSONObject cardBody = new JSONObject()
                .put("idList", getListId(boardId))
                .put("name", "Test_Card_1");
        Response createCard = given()
                .baseUri(tp.getValue("url") + "/1/cards")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(cardBody.toString())
                .post();
        assertEquals(createCard.getStatusCode(), 200);
        JSONObject createCardResponse = new JSONObject(createCard.asString());

        // Проверки
        String cardId = createCardResponse.getString("id");
        Response getCard = given()
                .baseUri(tp.getValue("url") + "/1/cards/" + cardId)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .get();

        JSONObject getCardsResponse = new JSONObject(getCard.asString());
        assertEquals(getCard.getStatusCode(), 200);
        assertEquals(getCardsResponse.getString("name"), "Test_Card_1");

        // Удаление доски
        deleteBoard(boardId);
    }


}
