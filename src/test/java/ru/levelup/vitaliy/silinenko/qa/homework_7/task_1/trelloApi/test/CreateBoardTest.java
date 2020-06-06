package ru.levelup.vitaliy.silinenko.qa.homework_7.task_1.trelloApi.test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.util.Date;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class CreateBoardTest extends TrelloApiTestBase{

    @Test
    public void createBoardTest(){

        String nameOfBoard = "LevelUpBoard_" + new Date().getTime();
        JSONObject body = new JSONObject().put("name", nameOfBoard);

        Response createBoard = given()
                .baseUri(tp.getValue("url") + "/1/boards/")
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post();

        assertEquals(createBoard.getStatusCode(), 200);
        JSONObject createBoardResponse = new JSONObject(createBoard.asString());

        // Проверки
        String boardId = createBoardResponse.getString("id");
        Response getBoard = given()
                .baseUri(tp.getValue("url") + "/1/boards/" + boardId)
                .queryParam("key", tp.getValue("key"))
                .queryParam("token", tp.getValue("token"))
                .get();

        JSONObject getBoardResponse = new JSONObject(getBoard.asString());
        assertEquals(getBoard.getStatusCode(), 200);
        assertEquals(getBoardResponse.getString("name"), nameOfBoard);


        // Удаление доски
        deleteBoard(boardId);


    }
}
